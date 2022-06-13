package com.revature.movieapp.favorite;

import com.revature.movieapp.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite {


    @Id
    @Column(name = "movieID")
    private String movieID;
    @ManyToOne(optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;

}
