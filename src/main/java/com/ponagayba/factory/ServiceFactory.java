package com.ponagayba.factory;

import com.ponagayba.service.*;

public class ServiceFactory {

    public static UserService getUserService() {
        return new UserServiceImpl(DAOFactory.getUserDao());
    }

    public static ProductService getProductService() {
        return new ProductServiceImpl((DAOFactory.getProductDao()));
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl(DAOFactory.getCategoryDao(), getProductService());
    }
}
