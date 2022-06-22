package com.revature.blockbusster.customer;

import com.revature.blockbusster.util.exceptions.AuthenticationException;
import com.revature.blockbusster.util.exceptions.InvalidRequestException;
import com.revature.blockbusster.util.exceptions.ResourcePersistanceException;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServices implements Serviceable<Customer> {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServices(CustomerDao customerDao) {this.customerDao = customerDao;}

    @Override
    public Customer create(Customer newCustomer) {
        return customerDao.save(newCustomer);
    }

    @Override
    public Customer update(Customer updatedCustomer) { return customerDao.save(updatedCustomer);}

    @Override
    public boolean delete(String email){
        customerDao.deleteById(email);
        return true;
    }

    @Override
    public Customer readById(String email) throws ResourcePersistanceException {
         return customerDao.findById(email).get();

    }

    public Customer authenticateCustomer(String email, String password){

        if(password == null || password.trim().equals("") || email == null || email.trim().equals("")) {
            throw new InvalidRequestException("Either email or password is an invalid entry. Please try logging in again");
        }

        Optional<Customer> authenticatedCustomer = customerDao.authenticateCustomer(email, password);

        if (!authenticatedCustomer.isPresent()){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticatedCustomer.get();

    }


}
