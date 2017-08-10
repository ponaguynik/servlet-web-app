package com.ponagayba.factory;

import com.ponagayba.dao.*;

public class DAOFactory {

    public static ProductDao getProductDao() {
        return new ProductDaoImpl(ConnectionFactory.getConnection());
    }

    public static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl(ConnectionFactory.getConnection());
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl(ConnectionFactory.getConnection());
    }
}
