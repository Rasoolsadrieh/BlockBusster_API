package com.revature.movieapp.util.web.servlets;

import com.revature.movieapp.customer.Customer;
import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import com.revature.movieapp.util.web.dto.FavoriteInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/test")
public class TestServlet {

    @GetMapping("/1")
    public @ResponseBody String test(){
        return "Welcome to the wonderful world of Spring";
    }

    @GetMapping("/2")
    public @ResponseBody String test2(){
        return "Hey, this is another get method. nice right.";
    }

    @PostMapping("/post-test")
    public @ResponseBody Customer postTest(@RequestBody Customer customer){
        return customer;
    }

    @PostMapping("/post-favorite")
    public @ResponseBody FavoriteInitializer postTestFavorite(@RequestBody FavoriteInitializer favorite){
        return favorite;
    }

    @GetMapping("/testException")
    public void testException(){
        throw new InvalidRequestException("Sorry don't hit this endpoint");
    }

    @GetMapping("/testException1")
    public void testException1(){
        throw new InvalidRequestException("Sorry don't hit this endpoint");
    }
    @GetMapping("/testException2")
    public void testException2(){
        throw new InvalidRequestException("Sorry don't hit this endpoint");
    }
    @GetMapping("/testException3")
    public void testException3(){
        throw new InvalidRequestException("Sorry don't hit this endpoint");
    }

    @GetMapping("/testException4")
    public void testException4(){
        throw new AuthenticationException("Sorry don't hit this unauthorized endpoint");
    }


}
