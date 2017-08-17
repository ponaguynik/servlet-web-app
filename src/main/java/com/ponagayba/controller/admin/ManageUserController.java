package com.ponagayba.controller.admin;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.Role;
import com.ponagayba.model.User;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManageUserController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        ModelAndView result = new ModelAndView("admin/admin");
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = Factory.getUserService().findById(userId);
        if (user == null) {
            throw new PageNotFoundException();
        }
        List<Role> roles = Factory.getRoleService().getAll();
        result.addAttribute("page", "manageUser");
        result.addAttribute("roles", roles);
        result.addAttribute("user", user);
        return result;
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        return null;
    }
}
