package com.revature.movieapp.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CreditCardServlet {

    private final CreditCardServices creditCardServices;

    @Autowired
    public CreditCardServlet(CreditCardServices creditCardServices) {
        this.creditCardServices = creditCardServices;
    }


}
