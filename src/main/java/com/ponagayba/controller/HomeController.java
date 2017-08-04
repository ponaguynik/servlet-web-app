package com.ponagayba.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("home");
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new UnsupportedOperationException();
    }
}
