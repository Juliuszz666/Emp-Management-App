package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("../frontend/themes/my-theme/start_view.css")

public class LoginInput extends TextField {

    private final static int MAX_LENGTH = 20;

    public LoginInput() {
        setPlaceholder("Login");
        addClassName("login-input");
        addClassName("input-general-class");
        setMaxLength(MAX_LENGTH); // remove magic number
    }
}
