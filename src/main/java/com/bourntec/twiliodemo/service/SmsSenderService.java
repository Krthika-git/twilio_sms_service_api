/**
 * 
 */
package com.bourntec.twiliodemo.service;

import com.bourntec.twiliodemo.Model.SmsRequest;

/**
 * @author KarthikaJ
 *
 */
public interface SmsSenderService {
	 void sendSms(SmsRequest smsRequest);

}
