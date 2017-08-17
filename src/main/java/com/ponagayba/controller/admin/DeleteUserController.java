package com.ponagayba.controller.admin;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        Factory.getUserService().deleteUser(userId);
        ModelAndView result = new ModelAndView("/admin/users");
        result.setRedirect(true);
        return result;
    }
}
