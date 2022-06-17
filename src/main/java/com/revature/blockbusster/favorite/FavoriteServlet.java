package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerServices;
import com.revature.blockbusster.util.web.dto.FavoriteInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FavoriteServlet {

    private final FavoriteServices favoriteServices;
    private final CustomerServices customerServices;

    @Autowired
    public FavoriteServlet(FavoriteServices favoriteServices, CustomerServices customerServices) {
        this.favoriteServices = favoriteServices;
        this.customerServices = customerServices;
    }

    @PostMapping("/favorite")
    public ResponseEntity<Favorite> createFavorite(@RequestBody FavoriteInitializer initFav){

        Favorite newFavorite = new Favorite();
        Customer accountEmail = customerServices.readById(initFav.getAccountEmail());

        newFavorite.setMovieId(initFav.getMovieId());
        newFavorite.setAccountEmail(accountEmail);

        Favorite listedFavorite = favoriteServices.create(newFavorite);
        return new ResponseEntity<>(listedFavorite, HttpStatus.CREATED);
    }

    @GetMapping("/favorite/{email}")
    public ResponseEntity<List<Favorite>> getFavorite(@PathVariable String email){
        Customer customer = customerServices.readById(email);
        List<Favorite> favorites = favoriteServices.readByEmail(customer);
        return new ResponseEntity<>(favorites, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletefv/{movieId}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable String movieId) {
        favoriteServices.delete(movieId);
        return new ResponseEntity<Favorite>(HttpStatus.OK);
    }
}
