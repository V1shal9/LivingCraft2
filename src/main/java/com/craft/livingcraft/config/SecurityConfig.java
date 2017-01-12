package com.craft.livingcraft.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
//@ComponentScan(basePackageClasses = UserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 
	 @Autowired
	 DataSource dataSource;
	  
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   
	   auth.jdbcAuthentication().dataSource(dataSource)
	   .usersByUsernameQuery(
	   "select userName, userPassword, enabled from User where userName=?")
	  .authoritiesByUsernameQuery(
	   "select userName, roleName from User u, UserRole ur,Role r where u.userId=ur.userId and r.roleId=ur.roleId and userName=?");
	 } 
	  
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	 
	   http.authorizeRequests()
	  .antMatchers("/category","/subcategory","/supplier","/product").access("hasRole('ROLE_ADMIN')")  
	  .anyRequest().permitAll()
	  .and()
	    .formLogin().loginPage("/login").failureUrl("/login?error").loginProcessingUrl("/perform_login").defaultSuccessUrl("/")
	    .usernameParameter("userName").passwordParameter("userPassword")
//	  .and()
//	    .logout().logoutSuccessUrl("/logout")
	   .and()
	    .csrf().disable();
	 }
	}
