package com.ponagayba.filter;

import com.ponagayba.factory.Factory;
import com.ponagayba.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("TOKEN")) {
                try {
                    user = Factory.getUserService().findByToken(cookie.getValue());
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
            }
        }
        if (user != null) {
            req.setAttribute("user", user);
            chain.doFilter(request, response);
        } else {
            req.setAttribute("error", "You have to login first");
            req.setAttribute("uri", "/login");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
