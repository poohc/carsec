package com.pama.common.util;

public class CommonUtil {
	
	 /**
	 * nullcheck
	 * @param str, Defaultvalue
	 * @return
	 */
	 public static String nullcheck(String str,  String Defaultvalue ) throws Exception
	 {
	      String ReturnDefault = "" ;
	      if (str == null)
	      {
	          ReturnDefault =  Defaultvalue ;
	      }
	      else if (str == "" )
	     {
	          ReturnDefault =  Defaultvalue ;
	      }
	      else
	      {
	                  ReturnDefault = str ;
	      }
	       return ReturnDefault ;
	 }
	 /**
	 * BASE64 Encoder
	 * @param str
	 * @return
	 */
	public static String base64Encode(String str)  throws java.io.IOException {
	    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    byte[] strByte = str.getBytes();
	    String result = encoder.encode(strByte);
	    return result ;
	}

	/**
	 * BASE64 Decoder
	 * @param str
	 * @return
	 */
	public static String base64Decode(String str)  throws java.io.IOException {
	    sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	    byte[] strByte = decoder.decodeBuffer(str);
	    String result = new String(strByte);
	    return result ;
	}
	
}
