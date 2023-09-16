package com.fuzzyrock.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {
    UserDetails john =
        User.builder().username("john").password("{noop}1234qwer").roles("EMPLOYEE").build();

    UserDetails mary =
        User.builder()
            .username("mary")
            .password("{noop}1234qwer")
            .roles("EMPLOYEE", "MANAGER")
            .build();

    UserDetails susan =
        User.builder()
            .username("susan")
            .password("{noop}1234qwer")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build();

    return new InMemoryUserDetailsManager(john, mary, susan);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())
        .formLogin(
            form ->
                form.loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll())
        .logout(LogoutConfigurer::permitAll); // allow all to access login page

    return httpSecurity.build();
  }
}
