package com.revature.blockbusster.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "fname")
    private String fName;
    @Column(name = "lname")
    private String lName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;
    @Column(name = "dob")
    private String dob;

//    public Customer(String email, String fName, String lName, String password, String dob) {
//        this.email = email;
//        this.fName = fName;
//        this.lName = lName;
//        this.password = password;
//        this.dob = dob;
//    }
//
//    public Customer() {
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getfName() {
//        return fName;
//    }
//
//    public void setfName(String fName) {
//        this.fName = fName;
//    }
//
//    public String getlName() {
//        return lName;
//    }
//
//    public void setlName(String lName) {
//        this.lName = lName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "email='" + email + '\'' +
//                ", fName='" + fName + '\'' +
//                ", lName='" + lName + '\'' +
//                ", password='" + password + '\'' +
//                ", dob='" + dob + '\'' +
//                '}';
//    }
}


