package com.julian.employeemanagementapp.components.startview;

import com.julian.employeemanagementapp.security.AuthenticateLogin;
import com.julian.employeemanagementapp.security.LoginData;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.data.binder.Binder;

public class LoginForm extends FormLayout {

    private final Binder<LoginData> binder = new Binder<>(LoginData.class);

    public LoginForm() {
        setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        setClassName("login-form");
        LoginInput loginInput = new LoginInput();
        PasswordInput passwordInput = new PasswordInput();
        LoginButton loginButton = new LoginButton();

        LoginData loginData = new LoginData("", "");

        binder.setBean(loginData);
        binder.bind(loginInput, LoginData::getUsername, LoginData::setUsername);
        binder.bind(passwordInput, LoginData::getPassword, LoginData::setPassword);

        add(loginInput, passwordInput, loginButton);
        loginButton.addClickListener(e -> {
            boolean x = AuthenticateLogin.authenticate(binder.getBean());
            System.out.println(x);
        });
    }
}
