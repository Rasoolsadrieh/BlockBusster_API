package com.revature.movieapp.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderServlet {
     private final OrderServices orderServices;
    @Autowired
    public OrderServlet(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

}
