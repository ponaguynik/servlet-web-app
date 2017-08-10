package com.ponagayba.controller;

import com.ponagayba.exception.PageNotFoundException;
import com.ponagayba.factory.ServiceFactory;
import com.ponagayba.model.Category;
import com.ponagayba.model.Product;
import com.ponagayba.service.CategoryService;
import com.ponagayba.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryController extends Controller {

    @Override
    protected ModelAndView processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException, SQLException {
        ModelAndView result = new ModelAndView("category");
        String categoryName = request.getParameter("name");
        Category category = ServiceFactory.getCategoryService().getCategoryByName(categoryName);
        if (category == null)
            throw new PageNotFoundException();
        result.addAttribute("category", category);
        return result;
    }

    @Override
    protected ModelAndView processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PageNotFoundException {
        throw new UnsupportedOperationException();
    }
}
