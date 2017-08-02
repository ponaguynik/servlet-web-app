package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.Category;
import com.ponagayba.util.URIParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoriesController extends Controller {

    @Override
    protected String processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        if (URIParser.parse(request.getRequestURI()).length > 1) {
            return chain(request, response, "category");
        }
        List<Category> categories = Factory.getCategoryService().getAll();
        request.setAttribute("categories", categories);
        return "categories";
    }

    @Override
    protected String processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new UnsupportedOperationException();
    }
}
