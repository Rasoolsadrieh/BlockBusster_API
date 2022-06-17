package com.revature.blockbusster.creditcard;

import com.revature.blockbusster.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @Column(name = "cc_number")
    private String ccNumber;
    @Column(name = "cc_name")
    private String ccName;
    @Column(name = "cvv")
    private int cvv;
    @Column(name = "exp_date")
    private String expDate;
    @Column(name = "zip")
    private int zip;
    @Column(name = "credit_limit")
    private int limit;
    @ManyToOne(optional = false)
   // @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_email", referencedColumnName = "email")
    private Customer customerEmail;

//    public CreditCard(String ccNumber, String ccName, int cvv, String expDate, int zip, int limit, Customer customerEmail) {
//        this.ccNumber = ccNumber;
//        this.ccName = ccName;
//        this.cvv = cvv;
//        this.expDate = expDate;
//        this.zip = zip;
//        this.limit = limit;
//        this.customerEmail = customerEmail;
//    }
//
//    public CreditCard() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CreditCard that = (CreditCard) o;
//        return cvv == that.cvv && zip == that.zip && limit == that.limit && Objects.equals(ccNumber, that.ccNumber) && Objects.equals(ccName, that.ccName) && Objects.equals(expDate, that.expDate) && Objects.equals(customerEmail, that.customerEmail);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ccNumber, ccName, cvv, expDate, zip, limit, customerEmail);
//    }
//
//    public String getCcNumber() {
//        return ccNumber;
//    }
//
//    public void setCcNumber(String ccNumber) {
//        this.ccNumber = ccNumber;
//    }
//
//    public String getCcName() {
//        return ccName;
//    }
//
//    public void setCcName(String ccName) {
//        this.ccName = ccName;
//    }
//
//    public int getCvv() {
//        return cvv;
//    }
//
//    public void setCvv(int cvv) {
//        this.cvv = cvv;
//    }
//
//    public String getExpDate() {
//        return expDate;
//    }
//
//    public void setExpDate(String expDate) {
//        this.expDate = expDate;
//    }
//
//    public int getZip() {
//        return zip;
//    }
//
//    public void setZip(int zip) {
//        this.zip = zip;
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }
//
//    public Customer getCustomerEmail() {
//        return customerEmail;
//    }
//
//    public void setCustomerEmail(Customer customerEmail) {
//        this.customerEmail = customerEmail;
//    }
//
//    @Override
//    public String toString() {
//        return "CreditCard{" +
//                "ccNumber='" + ccNumber + '\'' +
//                ", ccName='" + ccName + '\'' +
//                ", cvv=" + cvv +
//                ", expDate='" + expDate + '\'' +
//                ", zip=" + zip +
//                ", limit=" + limit +
//                ", customerEmail=" + customerEmail +
//                '}';
//    }
}
