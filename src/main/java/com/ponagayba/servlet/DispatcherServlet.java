package com.ponagayba.servlet;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {

    private static final String JSP_LOCATION = "/WEB-INF/jsp/%s.jsp";

    private Map<String, Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        controllerMap.put("GET/pages/", Factory.getHomeController());
        controllerMap.put("GET/pages/home", Factory.getHomeController());
        controllerMap.put("GET/pages/login", Factory.getLoginController());
        controllerMap.put("POST/pages/login", Factory.getLoginController());
        controllerMap.put("POST/pages/logout", Factory.getLogoutController());
        controllerMap.put("GET/pages/categories", Factory.getCategoriesController());
        controllerMap.put("GET/pages/category", Factory.getCategoryController());
        controllerMap.put("GET/pages/product", Factory.getProductController());
        controllerMap.put("GET/pages/signup", Factory.getSignUpController());
        controllerMap.put("POST/pages/signup", Factory.getSignUpController());
        controllerMap.put("GET/pages/profile", Factory.getProfileController());
    }

    private Controller getController(HttpServletRequest request) throws PageNotFoundException {
        String methodUri = request.getMethod() + request.getRequestURI().split(";")[0];
        Controller result = controllerMap.get(methodUri);
        if (result == null) {
            throw new PageNotFoundException();
        }
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Controller controller = getController(request);
            ModelAndView modelAndView = controller.process(request, response);
            render(modelAndView, request, response);
        } catch (PageNotFoundException e) {
            response.sendError(404);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    private void render(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Map.Entry<String, Object> entry : modelAndView.getModel().entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        if (modelAndView.getView().equals(request.getPathInfo().substring(1))) {
            request.getRequestDispatcher(String.format(JSP_LOCATION, modelAndView.getView())).forward(request, response);
        } else {
            response.sendRedirect(modelAndView.getView());
        }
    }
}
