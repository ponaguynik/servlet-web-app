package com.ponagayba.factory;

import com.ponagayba.dao.*;
import com.ponagayba.service.*;

public class Factory {

    public static UserService getUserService() {
        return new UserServiceImpl(getUserDao());
    }

    public static ProductService getProductService() {
        return new ProductServiceImpl(getProductDao());
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl(getCategoryDao(), getProductService());
    }

    private static ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    private static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    private static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
