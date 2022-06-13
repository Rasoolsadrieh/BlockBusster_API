package com.revature.movieapp.favorite;

import com.revature.movieapp.creditcard.CreditCardServices;
import com.revature.movieapp.customer.CustomerServices;
import com.revature.movieapp.order.OrderServices;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import com.revature.movieapp.util.interfaces.Authable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class FavoriteServlet implements Authable {

    private final FavoriteServices favoriteServices;

    private final CustomerServices customerServices;


    @Autowired
    public FavoriteServlet(FavoriteServices favoriteServices, CustomerServices customerServices) {
        this.favoriteServices = favoriteServices;
        this.customerServices = customerServices;
    }

    @PostMapping("/addFavorite")

    public ResponseEntity<Favorite> saveFavorite(@RequestBody @Valid Favorite favorite){
        Favorite newFavorite = favoriteServices.create(favorite);
        return new ResponseEntity<>(newFavorite, HttpStatus.CREATED);
    }


    @GetMapping("/favoriteEx")
    public String favoriteException(){
        throw new InvalidRequestException("You don't want to request any favorite");
    }

}
