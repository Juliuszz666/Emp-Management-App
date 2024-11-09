package com.julian.employeemanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication
public class EmployeeManagementAppApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementAppApplication.class, args);
    }
}
