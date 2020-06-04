package com.message.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {
	
	public static String getMD5(byte[] data) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(data);
		byte[] resultBytes = md.digest();
		String resultString = BytesToString.fromBytesToString(resultBytes);
		return resultString;
	}
	
	public static String getSHA1(byte[] data) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(data);
		byte[] resultBytes = md.digest();
		String resultString = BytesToString.fromBytesToString(resultBytes);
		return resultString;
	}

}
