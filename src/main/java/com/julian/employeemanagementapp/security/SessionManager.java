package com.julian.employeemanagementapp.security;

import com.vaadin.flow.server.VaadinSession;

public class SessionManager {

    private static final int SESSION_TIMEOUT = 300;
    private static final String SESSION_ATTRIBUTE = "user";

    public static void startAndSetSession(String username) {
        VaadinSession.getCurrent().getSession().setMaxInactiveInterval(SESSION_TIMEOUT);
        VaadinSession.getCurrent().setAttribute(SESSION_ATTRIBUTE, username);
    }

    public static boolean isSessionActive() {
        return VaadinSession.getCurrent().getAttribute(SESSION_ATTRIBUTE) != null;
    }
}
