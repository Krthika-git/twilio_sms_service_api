/**
 * 
 */
package com.bourntec.twiliodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.twiliodemo.Model.SmsRequest;
import com.bourntec.twiliodemo.service.SmsSenderService;

import jakarta.validation.Valid;

/**
 * @author KarthikaJ
 *
 */

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {
	
	@Autowired
	SmsSenderService smsSenderService;

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
    	smsSenderService.sendSms(smsRequest);
    }
}
