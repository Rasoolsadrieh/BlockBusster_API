package com.revature.blockbusster.util.web.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.blockbusster.customer.Customer;
import javax.persistence.*;

public class CreditCardInitializer {
    private String ccNumber;
    private String ccName;
    private int cvv;
    private String expDate;
    private int zip;
    private int limit;
    private String customerEmail;

    public CreditCardInitializer() {
    }

    public CreditCardInitializer( String ccNumber, String ccName, int cvv, String expDate, int zip, int limit, String customerEmail) {
        this.ccNumber = ccNumber;
        this.ccName = ccName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zip = zip;
        this.limit = limit;
        this.customerEmail = customerEmail;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "CreditCardInitializer{" +
                "ccNumber='" + ccNumber + '\'' +
                ", ccName='" + ccName + '\'' +
                ", cvv=" + cvv +
                ", expDate='" + expDate + '\'' +
                ", zip=" + zip +
                ", limit=" + limit +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
