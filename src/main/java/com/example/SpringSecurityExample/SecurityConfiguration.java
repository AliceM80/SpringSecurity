package com.example.SpringSecurityExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  //use this method "auth. ..." called user details service and this let`s me pass in a user detail service instance
  // so I can create an implementation of the user detail service interface and make that as a spring service-->
  //annotated with the spring service and then set it to the authentication manager builder object and
  @Autowired
  UserDetailsService userDetailsService;


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("admin").hasRole("ADMIN")
            .antMatchers("user").hasAnyRole("ADMIN", "USER")
            .antMatchers("/").permitAll()
            .and().formLogin();
  }
  @Bean
  public PasswordEncoder getPasswordEncoder(){ return NoOpPasswordEncoder.getInstance();}
  }


