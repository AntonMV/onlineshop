package ru.leather.onlineshop.utils;

public class NullOrEmpty {

    public static Boolean IsNullOrEmpty(String value)
    {
        return (value == null || (value != null && value.isEmpty()));
    }
}
