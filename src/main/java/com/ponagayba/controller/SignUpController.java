package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.User;
import com.ponagayba.service.UserService;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        return new ModelAndView("signup");
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        ModelAndView result = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");

        String validationResult = validate(username, password, confPassword);
        if (validationResult == null) {
            Factory.getUserService().createNewUser(new User(username, password));
            result.setView("home");
            result.addAttribute("message", "User has been successfully created!");
        } else {
            result.setView("signup");
            result.addAttribute("error", validationResult);
        }
        return result;
    }

    private String validate(String username, String password, String confPassword) throws SQLException {
        String result = null;
        UserService userService = Factory.getUserService();
        if (userService.userExists(username)) {
            result = "Username with such username already exists.";
        } else if (!password.equals(confPassword)) {
            result = "Password does not match the confirm password.";
        }
        return result;
    }
}
