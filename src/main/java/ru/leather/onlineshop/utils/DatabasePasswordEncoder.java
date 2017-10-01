package ru.leather.onlineshop.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class DatabasePasswordEncoder {

    private static final Pattern pass_pattern = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
    public static final PasswordEncoder pass_encoder = new BCryptPasswordEncoder();


    public static String encode(String newPassword) {
        if (!StringUtils.hasText(newPassword)) {
            return null;
        }
        if (isEncoded(newPassword)) {
            return newPassword;
        }
        return pass_encoder.encode(newPassword);
    }

    public static boolean isMatch(String rawPassword, String password) {
        return pass_encoder.matches(rawPassword, password);
    }

    public static boolean isEncoded(String newPassword) {
        return pass_pattern.matcher(newPassword).matches();
    }
}
