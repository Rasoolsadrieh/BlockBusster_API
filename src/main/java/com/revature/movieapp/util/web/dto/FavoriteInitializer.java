package com.revature.movieapp.util.web.dto;
public class FavoriteInitializer {
    private String favorite;



    private int email;
    private String movieID;

    public FavoriteInitializer() {
    }

    public FavoriteInitializer(String favorite, int email, String movieID) {
        this.favorite = favorite;
        this.email = email;
        this.movieID = movieID;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    @Override
    public String toString() {
        return "FavoriteInitializer{" +
                "favorite='" + favorite + '\'' +
                ", email=" + email +
                ", movieID='" + movieID + '\'' +
                '}';
    }
}
