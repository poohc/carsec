package com.pama.processor.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pama.common.util.CommonUtil;
import com.pama.processor.SmsProcessor;
import com.pama.processor.vo.SendSmsVO;


@Service
public class SmsProcessorImpl implements SmsProcessor {

	private static final Log LOG = LogFactory.getLog(SmsProcessor.class);
	
	@Value("#{config['cafe24.sms.userId']}")
    private String sms_userid;
	
	@Value("#{config['cafe24.sms.secure']}")
    private String sms_secure;
	
	@Value("#{config['cafe24.sms.url.protocol']}")
    private String sms_protocol;
	
	@Value("#{config['cafe24.sms.url.http']}")
    private String sms_url_http;
	
	@Value("#{config['cafe24.sms.url.https']}")
    private String sms_url_https;
	
	@Value("#{config['cafe24.sms.sphone1']}")
    private String sms_sphone1;
	
	@Value("#{config['cafe24.sms.sphone2']}")
    private String sms_sphone2;
	
	@Value("#{config['cafe24.sms.sphone3']}")
    private String sms_sphone3;
	
	public int sendSms(SendSmsVO sendSmsVO) throws IOException, Exception {
		
		LOG.debug("send sms start ::::::::");
		String charsetType = "UTF-8"; //EUC-KR 또는 UTF-8
		
		String sms_url = "";
		if (sms_protocol.equals("1")) {
			sms_url = sms_url_http; // SMS 전송요청 URL
		} else if (sms_protocol.equals("2")) {
			sms_url = sms_url_https; // SMS 전송요청 URL
		}
		
	    String user_id = CommonUtil.base64Encode(sms_userid); // SMS아이디
	    String secure = CommonUtil.base64Encode(sms_secure); //인증키
	    
		String msg = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getMsg(), ""));
		String rphone = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRphone(), ""));
		//보내는 번호
		String sphone1 = CommonUtil.base64Encode(sms_sphone1);
		String sphone2 = CommonUtil.base64Encode(sms_sphone2);
		String sphone3 = CommonUtil.base64Encode(sms_sphone3);
		
		// 예약 날짜. 예)20090909
		String rdate = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRdate(), "")); 
		// 예약 시간. 예)173000 ,오후 5시 30분,예약시간은 최소 10분 이상으로 설정.
		String rtime = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRtime(), "")); 
		
		String mode = CommonUtil.base64Encode("1");
		
		String subject = "";
		if (CommonUtil.nullcheck(sendSmsVO.getSmsType(), "").equals("L")) {
			subject = CommonUtil.base64Encode(
					CommonUtil.nullcheck(sendSmsVO.getSubject(), ""));
		}	
		
		String testflag = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getTestflag(), "")); // 예) 테스트시: Y
		// 이름삽입번호. 예) 010-000-0000|홍길동
		String destination = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getDestination(), ""));
		// 반복설정.
		String repeatFlag = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRepeatFlag(), ""));
		// 반복횟수. 예) 1~10회 가능.
		String repeatNum = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRepeatNum(), ""));
		// 전송간격. 예)15분 이상부터 가능.
		String repeatTime = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getRepeatTime(), ""));
		
		String returnurl = CommonUtil.nullcheck(sendSmsVO.getReturnurl(), "");
		// 예) 사용할 경우 : 1, 성공시 대화상자(alert)를 생략.
		String nointeractive = CommonUtil.nullcheck(sendSmsVO.getNointeractive(), "");
		
		String smsType = CommonUtil.base64Encode(
				CommonUtil.nullcheck(sendSmsVO.getSmsType(), ""));

	    String[] host_info = sms_url.split("/");
	    String host = host_info[2];
	    String path = "/" + host_info[3];
	    int port = 80;

	    // 데이터 맵핑 변수 정의
	    String arrKey[]
	        = new String[] {"user_id","secure","msg", "rphone","sphone1","sphone2","sphone3","rdate","rtime"
	                                ,"mode","testflag","destination","repeatFlag","repeatNum", "repeatTime", "smsType", "subject"};
	    String valKey[]= new String[arrKey.length] ;
	    valKey[0] = user_id;
	    valKey[1] = secure;
	    valKey[2] = msg;
	    valKey[3] = rphone;
	    valKey[4] = sphone1;
	    valKey[5] = sphone2;
	    valKey[6] = sphone3;
	    valKey[7] = rdate;
	    valKey[8] = rtime;
	    valKey[9] = mode;
	    valKey[10] = testflag;
	    valKey[11] = destination;
	    valKey[12] = repeatFlag;
	    valKey[13] = repeatNum;
	    valKey[14] = repeatTime;
	    valKey[15] = smsType;
	    valKey[16] = subject;

	    String boundary = "";
	    Random rnd = new Random();
	    String rndKey = Integer.toString(rnd.nextInt(32000));
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] bytData = rndKey.getBytes();
	    md.update(bytData);
	    byte[] digest = md.digest();
	    for(int i =0;i<digest.length;i++)
	    {
	        boundary = boundary + Integer.toHexString(digest[i] & 0xFF);
	    }
	    boundary = "---------------------"+boundary.substring(0,11);

	    // 본문 생성
	    String data = "";
	    String index = "";
	    String value = "";
	    for (int i=0;i<arrKey.length; i++)
	    {
	        index =  arrKey[i];
	        value = valKey[i];
	        data +="--"+boundary+"\r\n";
	        data += "Content-Disposition: form-data; name=\""+index+"\"\r\n";
	        data += "\r\n"+value+"\r\n";
	        data +="--"+boundary+"\r\n";
	    }

	    LOG.debug(data);

	    InetAddress addr = InetAddress.getByName(host);
	    Socket socket = new Socket(host, port);
	    // 헤더 전송
	    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), charsetType));
	    wr.write("POST "+path+" HTTP/1.0\r\n");
	    wr.write("Content-Length: "+data.length()+"\r\n");
	    wr.write("Content-type: multipart/form-data, boundary="+boundary+"\r\n");
	    wr.write("\r\n");

	    // 데이터 전송
	    wr.write(data);
	    wr.flush();

	    // 결과값 얻기
	    BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),charsetType));
	    String line;
	    String alert = "";
	    ArrayList tmpArr = new ArrayList();
	    while ((line = rd.readLine()) != null) {
	        tmpArr.add(line);
	    }
	    wr.close();
	    rd.close();

	    String tmpMsg = (String)tmpArr.get(tmpArr.size()-1);
	    String[] rMsg = tmpMsg.split(",");
	    String Result= rMsg[0]; //발송결과
	    String Count= ""; //잔여건수
	    if(rMsg.length>1) {Count= rMsg[1]; }

	    //발송결과 알림
	    if(Result.equals("success")) {
	        alert = "성공적으로 발송하였습니다.";
	        alert += " 잔여건수는 " + Count + "건 입니다.";
	        LOG.debug(alert);
	        return 1;
	    }
	    else if(Result.equals("reserved")) {
	        alert = "성공적으로 예약되었습니다";
	        alert += " 잔여건수는 "+ Count+"건 입니다.";
	        LOG.debug(alert);
	        return 1;
	    }
	    else if(Result.equals("3205")) {
	        alert = "잘못된 번호형식입니다.";
	        LOG.debug(alert);
	        return 0;
	    }
	    else {
	        alert = "[Error]"+Result;
	        LOG.debug(alert);
	        return 0;
	    }

	}
}
