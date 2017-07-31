package com.ponagayba.util;

import com.ponagayba.controller.Controller;
import com.ponagayba.controller.HomeController;
import com.ponagayba.exception.PageNotFoundException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

    private static final String CTRL_PATH = "com.ponagayba.controller.";

    private HttpServletRequest request;

    public RequestHelper(HttpServletRequest request) {
        this.request = request;
    }

    public Controller getController() throws PageNotFoundException {
        String uri = request.getRequestURI();
        if (uri.equals("/"))
            return new HomeController();
        String name = uri.split("/")[1];
        String typeName = name.substring(0, 1).toUpperCase() + name.substring(1);
        try {
            Class type = Class.forName(CTRL_PATH + typeName + "Controller");
            return (Controller) type.asSubclass(Controller.class).newInstance();
        } catch (ReflectiveOperationException e) {
            throw new PageNotFoundException();
        }
    }
}
