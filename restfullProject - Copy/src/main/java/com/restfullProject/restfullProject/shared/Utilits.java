package com.restfullProject.restfullProject.shared;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utilits {
	private final Random random = new SecureRandom();
	private final String alfabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String generateUserId(int length) {
	 return generateRandomString(length);
 }

	private String generateRandomString(int length) {

		StringBuilder returnedStringBuilder = new StringBuilder(length);
		for (int i=0 ;i < length; i++) {
			returnedStringBuilder.append(alfabet.charAt(random.nextInt(alfabet.length()))) ;
		}
		return new String(returnedStringBuilder);
	}
}
