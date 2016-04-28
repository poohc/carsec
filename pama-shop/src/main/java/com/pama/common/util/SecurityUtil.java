package com.pama.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SecurityUtil {

    /***************************************************************************
     * 함 수 명 : md5enc
     * 인     자 : String str
     * 내     용 : 복호화가 안되게 문자열을 MD5 메시지 축약 을 한다.
     * 리 턴 값 : String
     **************************************************************************/
    public static String md5enc(String pwd) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(pwd.getBytes());
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            s.append(Integer.toString((digest[i] & 0xf0) >> 4, 16));
            s.append(Integer.toString(digest[i] & 0x0f, 16));
        }

        return s.toString();
    }

    /***************************************************************************
     * 함 수 명 : getRandom
     * 인     자 : int length
     * 내     용 : A-Z0-9 까지 조합하여 length길이 만큼 랜덤한 문자열을 생성합니다.
     * 리 턴 값 : String
     **************************************************************************/
    public static String getRandom(int length) throws Exception {
        Random random = new Random();
        String sTemp = "";
        String RNDValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < length; i++) {
            int nRnd = random.nextInt(RNDValue.length());
            sTemp = sTemp + RNDValue.substring(nRnd, nRnd + 1);
        }

        return sTemp.toString();
    }
    
    /***************************************************************************
     * 함 수 명 : getCertificationKey
     * 인     자 : String number
     *         int length
     * 내     용 : 넘어온 phone number로  millisecond를 곱해서 나온 수 중  length길이 만큼 랜덤한 
     *         문자열을 생성합니다.
     * 리 턴 값 : String
     **************************************************************************/    
    public static String getCertificationKey(String number, int length) throws Exception {
    	if (number==null || "".equals(number)) {
    		return "";
    	}
    	Random random = new Random();
    	String sTemp = "";
    	String tempKey = number.replaceAll("-", "").replaceAll(" ", "");

    	String resultKey = Long.toString(System.currentTimeMillis() 
    			* Integer.parseInt(tempKey.substring(tempKey.length()-7, tempKey.length())));
    	
        for (int i = 0; i < length; i++) {
            int nRnd = random.nextInt(resultKey.length());
            sTemp = sTemp + resultKey.substring(nRnd, nRnd + 1);
        }    	

    	return sTemp;
    }
}
