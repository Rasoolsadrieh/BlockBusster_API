package com.revature.blockbusster.order;


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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "movie_id")
    private String movieId;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "is_owned")
    private boolean isOwned;
    @Column(name = "return_date")
    private String returnDate;
//    @Column(name = "is_complete")
//    private int isComplete;
    @Column(name = "balance")
    private int balance;
    @ManyToOne(optional = false)
   // @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_email", referencedColumnName = "email")
//    @Column(name = "order_email")
    private Customer orderEmail;

//    public Order() {
//    }
//
//    public Order(int id, String movieId, String orderDate, boolean isOwned, String returnDate, Customer orderEmail) {
//        this.id = id;
//        this.movieId = movieId;
//        this.orderDate = orderDate;
//        this.isOwned = isOwned;
//        this.returnDate = returnDate;
//        this.orderEmail = orderEmail;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Order order = (Order) o;
//        return id == order.id && isOwned == order.isOwned && Objects.equals(movieId, order.movieId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(returnDate, order.returnDate) && Objects.equals(orderEmail, order.orderEmail);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, movieId, orderDate, isOwned, returnDate, orderEmail);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
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
//    public String getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(String orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public boolean isOwned() {
//        return isOwned;
//    }
//
//    public void setOwned(boolean owned) {
//        isOwned = owned;
//    }
//
//    public String getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(String returnDate) {
//        this.returnDate = returnDate;
//    }
//
//    public Customer getOrderEmail() {
//        return orderEmail;
//    }
//
//    public void setOrderEmail(Customer orderEmail) {
//        this.orderEmail = orderEmail;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", movieID='" + movieId + '\'' +
//                ", orderDate='" + orderDate + '\'' +
//                ", isOwned=" + isOwned +
//                ", returnDate='" + returnDate + '\'' +
//                ", orderEmail=" + orderEmail +
//                '}';
//    }
}
