package com.example.nativeNurseryApi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    // TODO implementation
    private int customerId;
    @NotBlank(message = "Field name can not be blank")
    private String name;
    @NotBlank(message = "Field phone can not be blank")
    @Size(min = 10, max = 10, message = "Field phone must be 10 digits")
    private String phone;
    @Email(message = "Field email must be valid e-mail address")
    @NotBlank(message = "Field email can not be blank")
    private String email;
    @NotBlank(message = "Field address_1 can not be blank")
    private String address1;
    private String address2;
    @NotBlank(message = "Field city can not be blank")
    private String city;
    @NotBlank(message = "Field state can not be blank")
    @Size(min = 2, max = 2, message = "Field state must be valid 2 char abbreviation")
    private String state;
    @NotBlank(message = "Field zip can not be blank")
    @Size(min = 5, max = 5, message = "Field zip must be 5 chars long")
    private String zip;

}
