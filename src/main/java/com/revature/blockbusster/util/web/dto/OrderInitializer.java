package com.revature.blockbusster.util.web.dto;

public class OrderInitializer {

    private String movieId;
    private String orderDate;
    private boolean isOwned;
    private String returnDate;
    private int balance;
    private String orderEmail;

    public OrderInitializer() {
    }

    public OrderInitializer(String movieId, String orderDate, boolean isOwned, String returnDate, int balance, String orderEmail) {
        this.movieId = movieId;
        this.orderDate = orderDate;
        this.isOwned = isOwned;
        this.returnDate = returnDate;
        this.balance = balance;
        this.orderEmail = orderEmail;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }
}
