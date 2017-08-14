package com.ponagayba.factory;

import com.ponagayba.controller.*;

public class ControllerFactory {

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
}
