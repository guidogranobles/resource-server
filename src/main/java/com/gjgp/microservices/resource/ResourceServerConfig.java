package com.gjgp.microservices.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private CustomAccessConverter customAcessTokenConverter;
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.and().authorizeRequests().anyRequest().permitAll();
	}

	
	@Override
	public void configure(final ResourceServerSecurityConfigurer security) {
		security.tokenServices(tokenServices());
		
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore());
		return tokenServices;
	}
	
	
	@Bean
	public TokenStore tokenStore() {
		
		return new JwtTokenStore(acessTokenConverter());
		
	}
	
	 @Bean
	    public JwtAccessTokenConverter acessTokenConverter() {
	        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        converter.setAccessTokenConverter(customAcessTokenConverter);

	        converter.setSigningKey("123");
	        return converter;
	    }

}
