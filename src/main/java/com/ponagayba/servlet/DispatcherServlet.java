package com.ponagayba.servlet;

import com.ponagayba.controller.Controller;
import com.ponagayba.controller.ModelAndView;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.ControllerFactory;

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
        controllerMap.put("GET/pages/", ControllerFactory.getHomeController());
        controllerMap.put("GET/pages/home", ControllerFactory.getHomeController());
        controllerMap.put("GET/pages/login", ControllerFactory.getLoginController());
        controllerMap.put("POST/pages/login", ControllerFactory.getLoginController());
        controllerMap.put("POST/pages/logout", ControllerFactory.getLogoutController());
        controllerMap.put("GET/pages/categories", ControllerFactory.getCategoriesController());
        controllerMap.put("GET/pages/category", ControllerFactory.getCategoryController());
        controllerMap.put("GET/pages/product", ControllerFactory.getProductController());
    }

    public Controller getController(HttpServletRequest request) throws PageNotFoundException {
        String methodUri = request.getMethod() + request.getRequestURI();
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

    public void render(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Map.Entry<String, Object> entry : modelAndView.getModel().entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        request.getRequestDispatcher(String.format(JSP_LOCATION, modelAndView.getView())).forward(request, response);
    }
}
