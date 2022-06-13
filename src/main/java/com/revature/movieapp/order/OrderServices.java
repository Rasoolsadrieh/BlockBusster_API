package com.revature.movieapp.order;

import com.revature.movieapp.creditcard.CreditCardDao;
import com.revature.movieapp.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class OrderServices implements Serviceable<Order> {
    private OrderDao orderDao;
    private CreditCardDao creditCardDao;
    @Autowired
    public void CreditCardServices(OrderDao orderDao, CreditCardDao creditCardDao) {
        this.orderDao = orderDao;
        this.creditCardDao = creditCardDao;
    }

    public OrderServices(OrderDao orderDao, CreditCardDao creditCardDao) {
        this.orderDao = orderDao;
        this.creditCardDao = creditCardDao;
    }


    @Override
    public Order create(Order newOrder) {
        return orderDao.save(newOrder);
    }

    @Override
    public List<Order> readAll() {
        return (List<Order>) orderDao.findAll();
    }

    @Override
    public Order readById(String id) {
        int idInt = Integer.parseInt(id);
        return orderDao.findById(idInt).get();
    }

    @Override
    public Order update(Order updatedOrder) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(Order object) {
        return false;
    }
}
