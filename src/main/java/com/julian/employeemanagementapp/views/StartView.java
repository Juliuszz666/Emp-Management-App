package com.julian.employeemanagementapp.views;

import com.julian.employeemanagementapp.components.startview.*;
import com.julian.employeemanagementapp.security.SessionManager;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("")
public class StartView extends VerticalLayout implements BeforeEnterObserver {

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

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if(SessionManager.isSessionActive()) {
            event.forwardTo(MainView.class);
        }
    }
}
