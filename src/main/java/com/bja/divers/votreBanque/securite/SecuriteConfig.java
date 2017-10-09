package com.bja.divers.votreBanque.securite;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
       .withUser("admin").password("1234").roles("ADMIN","USER");
       
       auth.inMemoryAuthentication()
       .withUser("user2").password("1234").roles("USER");
//        super.configure(auth);
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//	http.formLogin(); // authentification basé sur un formulaire (en l'occurence le formulaire default de spring-securite
	http.formLogin().loginPage("/login"); // formulaire spring-secu  fait maison :) login.html
	
	http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER"); // role user pour acceder à ces actions
	http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN"); // role admin pour acceder à ces actions
	
//        super.configure(http);
    }
    
}
