package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.Factory;
import com.ponagayba.model.Product;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        ModelAndView result = new ModelAndView("category");
        String categoryName = request.getParameter("name");
        List<Product> products = Factory.getProductService().getAllOfCategory(categoryName);
        if (products == null)
            throw new PageNotFoundException();
        result.addAttribute("category", request.getParameter("category"));
        result.addAttribute("products", products);
        return result;
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        throw new UnsupportedOperationException();
    }
}
