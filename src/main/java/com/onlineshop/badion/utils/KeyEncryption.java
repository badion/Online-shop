package com.onlineshop.badion.utils;

import java.security.MessageDigest;

public class KeyEncryption {

private static final String defaultSalt = "saltForPassword1";
	
	public static String getEncryptedKey (String password, String salt){
		byte[] encryptedKey = null;
		
		try{
			byte[] bytesKey = (defaultSalt + password + salt).getBytes("UTF-8");
	
			MessageDigest md = MessageDigest.getInstance("MD5");
			encryptedKey = md.digest(bytesKey);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		StringBuilder builder = new StringBuilder();
		for (byte singleByte: encryptedKey){
			builder.append(singleByte + "");
		}
		
		return builder.toString();
		
	}
}

