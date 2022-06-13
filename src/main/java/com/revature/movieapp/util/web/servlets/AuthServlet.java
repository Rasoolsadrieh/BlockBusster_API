package com.revature.movieapp.util.web.servlets;

import com.revature.movieapp.customer.Customer;
import com.revature.movieapp.customer.CustomerServices;
import com.revature.movieapp.util.web.dto.LoginCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthServlet {

    private final CustomerServices customerServices;

    @Autowired
    public AuthServlet(CustomerServices customerServices){
        this.customerServices = customerServices;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void authorizeCustomer(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
        Customer authCustomer = customerServices.authenticateCustomer(loginCreds.getEmail(), loginCreds.getPassword());
        httpSession.setAttribute("authCustomer", authCustomer);
    }

    @DeleteMapping
    public void logout(HttpSession session){
        session.invalidate();
    }

}
