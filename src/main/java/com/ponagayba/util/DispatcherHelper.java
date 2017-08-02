package com.ponagayba.util;

import com.ponagayba.controller.Controller;
import com.ponagayba.controller.HomeController;
import com.ponagayba.exception.PageNotFoundException;

import javax.servlet.http.HttpServletRequest;

public class DispatcherHelper {

    private static final String CTRL_PATH = "com.ponagayba.controller.";

    public static synchronized Controller getController(String name) throws PageNotFoundException {
        if (name.equals("")) {
            return new HomeController();
        }
        String typeName = name.substring(0, 1).toUpperCase() + name.substring(1);
        try {
            Class type = Class.forName(CTRL_PATH + typeName + "Controller");
            return (Controller) type.asSubclass(Controller.class).newInstance();
        } catch (ReflectiveOperationException e) {
            throw new PageNotFoundException();
        }
    }
}
