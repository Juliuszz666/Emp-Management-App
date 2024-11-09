package com.julian.employeemanagementapp.components.startview;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.Component;

@CssImport("../frontend/themes/my-theme/start_view.css")

public class LayoutContainer extends Div {

    public LayoutContainer(Component... components) {
        add(components);
        addClassName("layout-container");
    }
}
