package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("../frontend/themes/my-theme/start_view.css")

public class LoginInput extends TextField {

    public LoginInput() {
        setPlaceholder("Login");
        addClassName("login-input");
        addClassName("input-general-class");
        setMaxLength(20); // remove magic number
    }
}
