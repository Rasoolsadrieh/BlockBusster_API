package com.revature.movieapp.customer;

import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import com.revature.movieapp.util.exceptions.ResourcePersistanceException;
import com.revature.movieapp.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServices implements Serviceable<Customer> {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServices(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> readAll(){
        List<Customer> customers = (List<Customer>) customerDao.findAll();
        return customers;
    }

    @Override
    public Customer readById(String id) throws ResourcePersistanceException{

        Customer customer = customerDao.findById(id).get();
        return customer;
    }

    @Override
    public Customer update(Customer updatedCustomer) {
        customerDao.save(updatedCustomer);

        return updatedCustomer;
    }

    @Override
    public boolean delete(String email) {
        customerDao.deleteById(email);
        return true;
    }

    public boolean validateEmailNotUsed(String email){
        return customerDao.existsById(email);
    }

    public Customer create(Customer newCustomer){
        if(!validateInput(newCustomer)){
            // TODO: throw - what's this keyword?
            throw new InvalidRequestException("User input was not validated, either empty String or null values");
        }

        // TODO: Will implement with JDBC (connecting to our database)
        if(validateEmailNotUsed(newCustomer.getEmail())){
            throw new InvalidRequestException("User email is already in use. Please try again with another email or login into previous made account.");
        }

        Customer persistedCustomer = customerDao.save(newCustomer);

        if(persistedCustomer == null){
            throw new ResourcePersistanceException("Customer was not persisted to the database upon registration");
        }
        return persistedCustomer;
    }

    public String delete(Customer deleteCustomer){
        if(!validateInput(deleteCustomer)){
            throw new InvalidRequestException("User input was not validated, either empty String or null values");
        }

        // TODO: Will implement with JDBC (connecting to our database)
        if(!validateEmailNotUsed(deleteCustomer.getEmail())){
            throw new InvalidRequestException("User email doesn't exist");
        }
        customerDao.delete(deleteCustomer);

        return "The customer " + deleteCustomer.getEmail() + " has been deleted.";
    }

    @Override
    public boolean validateInput(Customer newCustomer) {
        if(newCustomer == null) return false;
        if(newCustomer.getFname() == null || newCustomer.getFname().trim().equals("")) return false;
        if(newCustomer.getLname() == null || newCustomer.getLname().trim().equals("")) return false;
        if(newCustomer.getEmail() == null || newCustomer.getEmail().trim().equals("")) return false;
        if(newCustomer.getPassword() == null || newCustomer.getPassword().trim().equals("")) return false;
        return newCustomer.getDob() != null || !newCustomer.getDob().trim().equals("");
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
