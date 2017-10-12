package com.bja.divers.votreBanque.securite;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

//	public static void main(String[] args) {
//		//StandardPasswordEncoder encoder = new StandardPasswordEncoder("SHA256");
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
//		
//		System.out.println(encoder.encode("1234"));
//	}
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
    //inMemoryAuthentication()
//      auth.inMemoryAuthentication()
//       .withUser("admin").password("1234").roles("ADMIN","USER");
//       
//       auth.inMemoryAuthentication()
//       .withUser("user2").password("1234").roles("USER");

     // jdbc Authentication  
       auth.jdbcAuthentication()
       	.dataSource(dataSource)
       	.usersByUsernameQuery("select username as principal, password as credentials, active from users where username = ?")  // verif deja si exist puis apres verif role
        .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username = ?")
        .rolePrefix("ROLE_")
        //.passwordEncoder(new StandardPasswordEncoder())
        ; // ajouter le prefix ROLE_
       
       
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
//	http.formLogin(); // authentification basé sur un formulaire (en l'occurence le formulaire default de spring-securite
	http.formLogin().loginPage("/login"); // formulaire spring-secu  fait maison :) login.html
	
	http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER"); // role user pour acceder à ces actions
	http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN"); // role admin pour acceder à ces actions
	
	http.exceptionHandling().accessDeniedPage("/403");  // redirection pour les erreurs de type 403
	
//        super.configure(http);
    }
    
}
