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
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView result = new ModelAndView();
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            result.setView("home");
        } else {
            result.setView("login");
        }
        return result;
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        ModelAndView result = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (Factory.getUserService().getUser(user) == null) {
            result.addAttribute("error", INCORRECT);
            result.setView("login");
        } else {
            request.getSession().setAttribute("user", user);
            result.setView("home");
        }
        return result;
    }
}
