package com.gjgp.microservices.resource;

import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessConverter extends DefaultAccessTokenConverter{
	
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		
		OAuth2Authentication authentication = super.extractAuthentication(map);
		authentication.setDetails(map);
		
		return authentication;
	}
	
}
