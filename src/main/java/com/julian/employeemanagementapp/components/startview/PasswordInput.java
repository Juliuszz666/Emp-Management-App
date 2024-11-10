package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.PasswordField;

@CssImport("../frontend/themes/my-theme/start_view.css")

public class PasswordInput extends PasswordField {

        private final static int MAX_LENGTH = 30;

        public PasswordInput() {
            setPlaceholder("Password");
            addClassName("password-input");
            addClassName("input-general-class");
            setMaxLength(MAX_LENGTH);
        }
}
