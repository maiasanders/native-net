package com.example.nativeNurseryApi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nursery {
    // TODO implementation
    private int nurseryId;
    @NotBlank(message = "Field name can not be blank")
    @Size(max = 100)
    private String name;
    @NotBlank(message = "Field website can not be blank")
    @Size(max = 200)
    private String website;
    @NotBlank(message = "Field phone_number can not be blank")
    @Size(min = 10, max = 10, message = "Field phone_number must be 10 digits")
    private String phoneNumber;
    @NotBlank(message = "Field primary_contact can not be blank")
    @Size(max = 100, message = "Field primary_contact must 100 char or less")
    private String primaryContact;
    private boolean hasStorefront;
    private boolean ships;
}
