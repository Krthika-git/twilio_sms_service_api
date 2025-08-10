package com.bourntec.twiliodemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author KarthikaJ
 *
 */
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

	private String accountSid;
	private String authToken;
	private String trialNumber;

	
	
}
