package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.order.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDao extends CrudRepository<Favorite, String> {

    @Query(value = "FROM Favorite WHERE accountEmail= :accountEmail")
    List<Favorite> favoriteHistory(Customer accountEmail);
}
