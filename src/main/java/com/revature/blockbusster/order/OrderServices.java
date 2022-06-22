package com.revature.blockbusster.order;


import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerDao;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServices implements Serviceable<Order> {

    private OrderDao orderDao;
    private CustomerDao customerDao;

//    private final Calendar calendar = Calendar.getInstance();


    @Autowired
    public OrderServices(OrderDao orderDao, CustomerDao customerDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
    }

//    int month = (calendar.get(calendar.MONTH))+1;
//    int day = calendar.get(calendar.DAY_OF_MONTH);
//    int returnDay = (calendar.get(calendar.DAY_OF_MONTH))+2;
//    int year = calendar.get(calendar.YEAR);
//    String theDate = month + "/" + day + "/" + year;
//    String theReturnDate = month + "/" + returnDay + "/" + year;
//
//    public Order rentMovie(int id, String movieID, String orderDate, String returnDate, String orderEmail) {
//        orderDate = theDate;
//        returnDate = theReturnDate;
//        Optional<Order> persistedOrder = orderDao.rentMovie(id, movieID, orderDate, returnDate, orderEmail);
//        return persistedOrder.get();
//    }
//
//    public Order completeOrder(int id){
//        Optional<Order> persistedOrder = orderDao.completeOrder(id);
//        return persistedOrder.get();
//    }


    @Override
    public Order create(Order newOrder) {return orderDao.save(newOrder);}

    @Override
    public Order update(Order updatedOrder) {return orderDao.save(updatedOrder);}

    @Override
    public Order readById(String orderEmail) {return null;}

    public List<Order> readByEmail(Customer orderEmail) {return  orderDao.orderHistory(orderEmail);}

    @Override
    public boolean delete(String orderEmail) {return false;}

    public List<Order> readAll(){ return (List<Order>) orderDao.findAll();}


}
