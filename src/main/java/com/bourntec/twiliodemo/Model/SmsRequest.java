/**
 * 
 */
package com.bourntec.twiliodemo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

/**
 * @author KarthikaJ
 *
 */
public class SmsRequest {


	 @NotBlank
	    private final String phoneNumber; // destination

	    @NotBlank
	    private final String message;

	    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
	                      @JsonProperty("message") String message) {
	        this.phoneNumber = phoneNumber;
	        this.message = message;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public String getMessage() {
	        return message;
	    }

	    @Override
	    public String toString() {
	        return "SmsRequest{" +
	                "phoneNumber= ..." + '\'' +
	                ", message='" + message + '\'' +
	                '}';
	    }
}
