package com.revature.blockbusster.util.web.dto;

public class FavoriteInitializer {

    private String movieId;

    private String accountEmail;

    public FavoriteInitializer() {
    }

    public FavoriteInitializer(String movieId, String accountEmail) {
        this.movieId = movieId;
        this.accountEmail = accountEmail;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
}
