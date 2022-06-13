package com.revature.movieapp.creditcard;

import com.revature.movieapp.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_card")

public class CreditCard {

    @Id
    @Column(name = "cc_number")
    private String cc_number;
    @Column(name = "cc_name")
    private String cc_name;


    @Column(name = "cvv")
    private int cvv;
    @Column(name = "exp_date")
    private String exp_date;
    @Column(name = "zip")
    private int zip;

    @Column(name = "credit_limit")
    private int credit_limit;
    @ManyToOne(optional = false)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Customer customer;

}

