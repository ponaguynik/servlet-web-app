package com.ponagayba.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class DispatcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().startsWith("/resources") || req.getRequestURI().contains(".")) {
            chain.doFilter(req, response);
        } else {
            if (request.getAttribute("uri") != null) {
                req.getRequestDispatcher("/pages" + request.getAttribute("uri")).forward(request, response);
            } else {
                req.getRequestDispatcher("/pages" + req.getRequestURI()).forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
