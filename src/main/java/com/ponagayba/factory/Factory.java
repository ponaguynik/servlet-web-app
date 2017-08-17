package com.ponagayba.factory;

import com.ponagayba.controller.*;
import com.ponagayba.controller.admin.DeleteUserController;
import com.ponagayba.controller.admin.ManageUserController;
import com.ponagayba.dao.*;
import com.ponagayba.model.Role;
import com.ponagayba.service.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    public static Controller getHomeController() {
        return new HomeController();
    }

    public static Controller getLoginController() {
        return new LoginController();
    }

    public static Controller getLogoutController() {
        return new LogoutController();
    }

    public static Controller getCategoriesController() {
        return new CategoriesController();
    }

    public static Controller getCategoryController() {
        return new CategoryController();
    }

    public static Controller getProductController() {
        return new ProductController();
    }

    public static Controller getSignUpController() {
        return new SignUpController();
    }

    public static Controller getProfileController() {
        return new ProfileController();
    }

    public static Controller getUsersController() {
        return new UsersController();
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            throw new RuntimeException("Driver was not initialized");
        }
        return connection;
    }

    public static ProductDao getProductDao() {
        return new ProductDaoImpl(getConnection());
    }

    public static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl(getConnection());
    }

    public static UserDao getUserDao() {
        return new UserDaoImpl(getConnection());
    }

    public static RoleDao getRoleDao() {
        return new RoleDaoImpl(getConnection());
    }

    public static UserService getUserService() {
        return new UserServiceImpl(getUserDao(), getRoleDao());
    }

    public static ProductService getProductService() {
        return new ProductServiceImpl((getProductDao()));
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl(getCategoryDao(), getProductService());
    }

    public static RoleService getRoleService() {
        return new RoleServiceImpl(getRoleDao());
    }

    public static Controller getDeleteUserController() {
        return new DeleteUserController();
    }

    public static Controller getManageUserController() {
        return new ManageUserController();
    }
}
