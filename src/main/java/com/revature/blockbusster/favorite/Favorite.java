package com.revature.blockbusster.favorite;

import com.revature.blockbusster.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite {
    @Id
    @Column(name = "movie_id")
    private String movieId;
    @ManyToOne(optional = false)
    // @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_email", referencedColumnName = "email")
    private Customer accountEmail;

//    public Favorite() {
//    }

//    public Favorite(String movieId, Customer accountEmail) {
//        this.movieId = movieId;
//        this.accountEmail = accountEmail;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Favorite favorite = (Favorite) o;
//        return Objects.equals(movieId, favorite.movieId) && Objects.equals(accountEmail, favorite.accountEmail);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(movieId, accountEmail);
//    }
//
//    public String getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(String movieId) {
//        this.movieId = movieId;
//    }
//
//    public Customer getAccountEmail() {
//        return accountEmail;
//    }
//
//    public void setAccountEmail(Customer accountEmail) {
//        this.accountEmail = accountEmail;
//    }
//
//    @Override
//    public String toString() {
//        return "Favorite{" +
//                "movieId='" + movieId + '\'' +
//                ", accountEmail=" + accountEmail +
//                '}';
//    }
}
