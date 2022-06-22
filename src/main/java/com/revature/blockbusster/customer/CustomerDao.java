package com.revature.blockbusster.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends CrudRepository<Customer, String> {
    @Query(value = "FROM Customer WHERE email= :email AND password = :password")
    Optional<Customer> authenticateCustomer(String email, String password);

}
