package com.ponagayba.servlet;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private String view;
    private Map<String, Object> model;


    public ModelAndView() {
        model = new HashMap<>();
    }

    public ModelAndView(String view) {
        model = new HashMap<>();
        this.view = view;
    }

    public ModelAndView addAttribute(String attributeName, Object attributeValue) {
        model.put(attributeName, attributeValue);
        return this;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
