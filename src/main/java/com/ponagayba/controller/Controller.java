package com.ponagayba.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Controller {

    public String process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getMethod().equals("GET"))
            return processGet(request, response);
        if (request.getMethod().equals("POST"))
            return processPost(request, response);
        else
            throw new UnsupportedOperationException();
    }

    protected abstract String processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract String processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
