package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.PasswordField;

@CssImport("../frontend/themes/my-theme/start_view.css")

public class PasswordInput extends PasswordField {

        public PasswordInput() {
            setPlaceholder("Password");
            addClassName("password-input");
            addClassName("input-general-class");
            setMaxLength(30); // remove magic number
        }
}
