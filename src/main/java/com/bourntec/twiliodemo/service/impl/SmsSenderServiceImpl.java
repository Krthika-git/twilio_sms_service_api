/**
 * 
 */
package com.bourntec.twiliodemo.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.twiliodemo.Model.SmsRequest;
import com.bourntec.twiliodemo.config.TwilioConfiguration;
import com.bourntec.twiliodemo.service.SmsSenderService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

/**
 * @author KarthikaJ
 *
 */

@Service("twilio")
public class SmsSenderServiceImpl implements SmsSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSenderServiceImpl.class);

    private final TwilioConfiguration twilioConfiguration;

//    @Autowired
    public SmsSenderServiceImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }

    }

	private boolean isPhoneNumberValid(String phoneNumber) {
		String regex = "^\\+?\\d{1,3}?[- .]?\\(?\\d{1,5}\\)?([- .]?\\d{1,4})*$";
		Pattern p = Pattern.compile(regex);
		if (phoneNumber == null) {
			return false;
		}
		Matcher m = p.matcher(phoneNumber);
		return m.matches();
	}

}
