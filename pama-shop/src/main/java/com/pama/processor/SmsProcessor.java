package com.pama.processor;

import java.io.IOException;

import com.pama.processor.vo.SendSmsVO;

public interface SmsProcessor {
	
	public int sendSms(SendSmsVO sendSmsVO) throws IOException, Exception;

}
