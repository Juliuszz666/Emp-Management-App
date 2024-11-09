package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.button.Button;

public class LoginButton extends Button {
    public LoginButton() {
        addClassName("input-general-class");
        addClassName("login-button");
        setText("Login");
    }
}
