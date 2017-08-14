package com.ponagayba.controller;

import com.ponagayba.factory.ServiceFactory;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LogoutController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ModelAndView result = new ModelAndView("home");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("TOKEN")) {
                ServiceFactory.getUserService().removeToken(cookie.getValue());
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        return result;
    }
}
