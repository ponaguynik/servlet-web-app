package com.ponagayba.servlet;

import com.ponagayba.controller.Controller;
import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.util.DispatcherHelper;
import com.ponagayba.util.URIParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String page;
        String controllerName = URIParser.parse(req.getRequestURI())[0];
        try {
            Controller controller = DispatcherHelper.getController(controllerName);
            page = controller.process(req, resp);
        } catch (PageNotFoundException e) {
            resp.sendError(404);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500);
            return;
        }
        dispatch(req, resp, page);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        page = String.format("/WEB-INF/jsp/%s.jsp", page);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
