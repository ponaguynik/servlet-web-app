package com.ponagayba.controller.admin;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserRolesController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PageNotFoundException, SQLException {
        return null;
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PageNotFoundException, SQLException {
        return null;
    }
}
