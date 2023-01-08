package com.start.security.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class PasswordEncoder {

	private final static int ITERATION_NUMBER = 1000;

	public String enPassword(String password, String salt) {
		String encriptPassword = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(salt.getBytes());
			byte[] input = digest.digest(password.getBytes("UTF-8"));
			for (int i = 0; i < ITERATION_NUMBER; i++) {
				digest.reset();
				input = digest.digest(input);
			}
			
			encriptPassword =  new String(Base64.getEncoder().encode(input));
//			log.info(encriptPassword);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return encriptPassword;
	}
	
	public String getSalt() {
		String value = "";
		try {
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			// Salt generation 128 bits long
			byte[] salt = new byte[16];
			secureRandom.nextBytes(salt);
			byte[] encoded = Base64.getEncoder().encode(salt);
			
			return new String(encoded);
		} catch(Exception e) {
			e.printStackTrace();
		}
		log.info(value);
		return value;
	}
	
	public boolean isEquaslPassword(String password, String dbEncriptPassword, String dbSalt ) {
		String encriptPassword = enPassword(password, dbSalt);
		if(encriptPassword.equals(dbEncriptPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static byte[] hash(byte[] seedKey, String hmac) {
		String security = null;
		if("HmacSHA1".equals(hmac)) {
			security = "SHA1";
		} else if("HmacSHA256".equals(hmac)) {
			security = "SHA-256";
		} else if("HmacSHA512".equals(hmac)) {
			security = "SHA-512";
		}
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(security);
			return messageDigest.digest(seedKey);
		} catch(Exception e) {
			e.printStackTrace();
			return seedKey;
		}
	}
}