package com.ponagayba.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DispatcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().contains("."))
            chain.doFilter(req, response);
        else
            req.getRequestDispatcher("/pages" + req.getRequestURI()).forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
