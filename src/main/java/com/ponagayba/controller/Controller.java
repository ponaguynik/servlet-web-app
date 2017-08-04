package com.ponagayba.controller;


import com.ponagayba.exception.PageNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Controller {

    public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        if (request.getMethod().equals("GET"))
            return processGet(request, response);
        if (request.getMethod().equals("POST"))
            return processPost(request, response);
        else
            throw new UnsupportedOperationException();
    }

    protected abstract ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException;

    protected abstract ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException;
}
