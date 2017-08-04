package com.ponagayba.controller;


import com.ponagayba.exception.PageNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ControllerMapping {

    private static Map<String, Controller> map = new HashMap<>();

    static {
        map.put("GET/pages/", new HomeController());
        map.put("GET/pages/home", new HomeController());
        map.put("GET/pages/login", new LoginController());
        map.put("POST/pages/login", new LoginController());
        map.put("POST/pages/logout", new LogoutController());
        map.put("GET/pages/categories", new CategoriesController());
        map.put("GET/pages/categories/*", new CategoryController());
    }

    public synchronized static Controller getController(HttpServletRequest request) throws PageNotFoundException {
        String methodUri = request.getMethod() + request.getRequestURI();
        Controller result = map.get(methodUri);
        if (result != null)
            return result;
        return getControllerRegex(methodUri);
    }

    private synchronized static Controller getControllerRegex(String methodUri) throws PageNotFoundException {
        for (Map.Entry<String, Controller> entry : map.entrySet()) {
            String key = entry.getKey();
            String pattern = key.replaceAll("\\*", "\\\\w+");
            pattern = "^" + pattern + "$";
            if (Pattern.matches(pattern, methodUri))
                return entry.getValue();
        }
        throw new PageNotFoundException();
    }
}
