package com.fifa.worldcup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

		http.authorizeRequests()
			.antMatchers("/403*").permitAll()
			.antMatchers("/fifaDetail*").permitAll()
			.antMatchers("/game").hasAnyRole("ADMIN", "USER")
			.antMatchers("/game/**").not().hasRole("USER")
			.antMatchers("/*").hasAnyRole("ADMIN", "USER");

		http
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/fifa", true)
			.loginPage("/login")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			.and()
			.csrf();

		http.logout().permitAll();
	};
}