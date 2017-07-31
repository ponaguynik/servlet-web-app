package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryController extends Controller {

    @Override
    protected String processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        String category = request.getRequestURI().split("/")[2];
        List<Product> products = Factory.getProductService().getAllOfCategory(category);
        if (products == null)
            throw new PageNotFoundException();
        request.setAttribute("products", products);
        request.setAttribute("category", category);
        return "products";
    }

    @Override
    protected String processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new UnsupportedOperationException();
    }
}
