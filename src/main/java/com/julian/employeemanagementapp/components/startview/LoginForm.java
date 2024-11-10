package com.julian.employeemanagementapp.components.startview;

import com.julian.employeemanagementapp.security.AuthenticateLogin;
import com.julian.employeemanagementapp.security.LoginData;
import com.julian.employeemanagementapp.security.SessionManager;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;

public class LoginForm extends FormLayout {

    private final LoginInput loginInput;
    private final PasswordInput passwordInput;
    private final LoginButton loginButton;
    private final Binder<LoginData> credentialsBean;
    private final LoginData loginData;

    private void setUpBean() {
        credentialsBean.setBean(loginData);
        credentialsBean.bind(loginInput, LoginData::getUsername, LoginData::setUsername);
        credentialsBean.bind(passwordInput, LoginData::getPassword, LoginData::setPassword);
    }

    private void setUpComponents() {
        add(loginInput, passwordInput, loginButton);
        loginButton.addClickListener(event -> {
            if(AuthenticateLogin.authenticate(loginData)) {
                SessionManager.startAndSetSession(loginData.getUsername());
                getUI().ifPresent(ui -> ui.navigate("main-view"));
            }
        });
    }

    public LoginForm() {
        setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        setClassName("login-form");
        loginInput = new LoginInput();
        passwordInput = new PasswordInput();
        loginButton = new LoginButton();
        loginData = new LoginData("", "");
        credentialsBean = new Binder<>(LoginData.class);

        setUpBean();
        setUpComponents();
    }
}
