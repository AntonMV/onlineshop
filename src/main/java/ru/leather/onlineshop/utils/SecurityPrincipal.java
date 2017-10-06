package ru.leather.onlineshop.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityPrincipal {

    private static Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    private static String username;
    private static String password;
    private static Boolean enable;


    public static Object getPrincipal() {
        return principal;
    }

    public static String getUsername() {
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        return username;
    }

    public static String getPassword() {
        if (principal instanceof UserDetails) {
            password = ((UserDetails)principal).getPassword();
        }
        return password;
    }

    public static Boolean getEnable() {
        if (principal instanceof UserDetails) {
            enable = ((UserDetails)principal).isEnabled();
        }
        return enable;
    }
}
