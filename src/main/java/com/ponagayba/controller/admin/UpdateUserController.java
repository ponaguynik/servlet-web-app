package com.ponagayba.controller.admin;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.User;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        ModelAndView result = new ModelAndView("admin/admin");
        result.addAttribute("page", "manageUser");
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = Factory.getUserService().findById(userId);
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        Factory.getUserService().updateUser(user);
        result.addAttribute("roles", Factory.getRoleService().getAll());
        result.addAttribute("user", user);
        return null;
    }
}
