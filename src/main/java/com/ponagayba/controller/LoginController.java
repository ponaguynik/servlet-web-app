package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.ServiceFactory;
import com.ponagayba.model.User;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController extends Controller {

    private static final String INCORRECT = "The username or password is incorrect";

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("login");
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        ModelAndView result = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if ((user = ServiceFactory.getUserService().getUser(user)) != null) {
            result.setView("profile");
            registerToken(user);
            response.addCookie(new Cookie("TOKEN", user.getToken()));
        } else {
            result.setView("login");
            result.addAttribute("error", INCORRECT);
        }
        return result;
    }

    private void registerToken(User user) throws SQLException {
        String token = user.getUsername() + System.nanoTime();
        user.setToken(token);
        ServiceFactory.getUserService().updateToken(user);
    }
}
