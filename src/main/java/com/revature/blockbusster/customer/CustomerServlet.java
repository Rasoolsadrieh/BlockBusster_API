package com.revature.blockbusster.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
@CrossOrigin
public class CustomerServlet {

    private final CustomerServices customerServices ;

    @Autowired
    public CustomerServlet(CustomerServices customerServices)
    {this.customerServices = customerServices;}

    @PostMapping("/register")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerServices.create(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String email){
        customerServices.delete(email);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
}