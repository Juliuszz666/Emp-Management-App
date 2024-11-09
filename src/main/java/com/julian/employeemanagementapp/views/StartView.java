package com.julian.employeemanagementapp.views;

import com.julian.employeemanagementapp.components.startview.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class StartView extends VerticalLayout {

    private Component[] components;

    private void initializeComponents() {
        H1 header = new H1("Welcome to the Employee Management App");
        Paragraph paragraph = new Paragraph("Please log in to access the app.");
        LoginForm loginForm = new LoginForm();
        components = new Component[] {header, paragraph, loginForm};

    }

    public StartView() {

        initializeComponents();
        LayoutContainer layoutContainer = new LayoutContainer(components);
        add(layoutContainer);

    }
}
