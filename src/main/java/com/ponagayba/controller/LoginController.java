package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends Controller {

    private static final String INCORRECT = "The username or password is incorrect";

    @Override
    protected String processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null)
            return "home";
        return "login";
    }

    @Override
    protected String processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (Factory.getUserService().getUser(user) == null) {
            request.setAttribute("message", INCORRECT);
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return "home";
    }
}
