package com.trainingcenter.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Embeddable
public class Address {

	 @NotBlank(message = "Detailed address is required")
	    private String detailedAddress;

	    @NotBlank(message = "City is required")
	    private String city;

	    @NotBlank(message = "State is required")
	    private String state;

	    @Pattern(regexp = "^\\d{6}$", message = "Pincode must be exactly 6 digits")
	    private String pincode;
}
