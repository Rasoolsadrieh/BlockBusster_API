package com.revature.blockbusster.order;


import com.revature.blockbusster.customer.Customer;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

    @Query(value = "FROM Order WHERE orderEmail= :orderEmail")
    List<Order> orderHistory(Customer orderEmail);


//    @Query(value = "INSERT into Order values id= :id, movieID = :movieID, rent, orderDate= :orderDate, returnDate= :returnDate, 0, 3, orderEmail= :orderEmail")
//    Optional<Order> rentMovie(int id, String movieID,String orderDate, String returnDate, String orderEmail);
//
//    @Query(value = "Update Order set isComplete= 1 where id= :id")
//    Optional<Order> completeOrder(int id);



}
