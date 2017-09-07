package ru.leather.onlineshop.service;

import ru.leather.onlineshop.model.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    void deleteOrder(Integer id);

    Order getByIdOrder(Integer id);

    Order editOrder(Order order);

    List<Order> getAll();

}
