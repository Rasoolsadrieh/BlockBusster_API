package com.revature.movieapp.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @NotBlank(message = "Hey you need a first name, it cannot be blank")
    @NotNull
    private String fname;
    private String lname;
    @Id
    @Email(message = "please provide valid email")
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String dob;

}
