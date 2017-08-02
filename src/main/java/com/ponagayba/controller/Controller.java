package com.ponagayba.controller;


import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.util.DispatcherHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Controller {

    public String process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        if (request.getMethod().equals("GET"))
            return processGet(request, response);
        if (request.getMethod().equals("POST"))
            return processPost(request, response);
        else
            throw new UnsupportedOperationException();
    }

    protected String chain(HttpServletRequest request, HttpServletResponse response, String controllerName)
            throws ServletException, IOException, PageNotFoundException {
        return DispatcherHelper.getController(controllerName).process(request, response);
    }

    protected abstract String processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException;

    protected abstract String processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException;
}
