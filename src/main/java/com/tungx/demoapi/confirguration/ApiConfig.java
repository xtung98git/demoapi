package com.tungx.demoapi.confirguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApiConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().antMatcher("/api/**").authorizeRequests().antMatchers("/api/admin/**")
                .hasAnyAuthority("ADMIN").antMatchers("/api/user/**").authenticated().anyRequest().permitAll();
    }
}
