package com.bja.divers.votreBanque.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.bja.divers.votreBanque.VotreBanqueApplication;

public class WebInitializer extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		
		
		return builder.sources(VotreBanqueApplication.class);
	}
}
