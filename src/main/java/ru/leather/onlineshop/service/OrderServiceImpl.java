package ru.leather.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leather.onlineshop.model.Order;
import ru.leather.onlineshop.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.delete(id);
    }

    @Override
    public Order getByIdOrder(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order editOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
