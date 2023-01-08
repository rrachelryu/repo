package com.start.security.util;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {

	private static Map<String, String> store = new ConcurrentHashMap<>();

	public void createSession(String value, HttpServletResponse response) {
		String token = UUID.randomUUID().toString();
		store.put(token, value);
		Cookie cookie = new Cookie("LOGIN_MEMBER", value);
		response.addCookie(cookie);
	}

	public String getSession(HttpServletRequest request) {
		Cookie sessionCookie = findCookie(request);
		if (sessionCookie == null) { // (2)
			return null;
		}
		return store.get(sessionCookie.getValue());
	}
	
	public Cookie findCookie(HttpServletRequest request) {
	    if(request.getCookies() == null) { //(1)
	        return null;
	    }
	    return Arrays.stream(request.getCookies()) //(2)
	            .filter(cookie -> cookie.getName().equals("LOGIN_MEMBER"))
	            .findFirst()
	            .orElse(null);
	}

}
