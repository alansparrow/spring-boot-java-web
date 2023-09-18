package com.fuzzyrock.demosecurity.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    jdbcUserDetailsManager.setUsersByUsernameQuery(
        "select user_id, pw, active from members where user_id=?");

    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
        "select user_id, role from roles where user_id=?");

    return jdbcUserDetailsManager;
  }

  //  @Bean
  //  public InMemoryUserDetailsManager userDetailsManager() {
  //    UserDetails john =
  //        User.builder().username("john").password("{noop}1234qwer").roles("EMPLOYEE").build();
  //
  //    UserDetails mary =
  //        User.builder()
  //            .username("mary")
  //            .password("{noop}1234qwer")
  //            .roles("EMPLOYEE", "MANAGER")
  //            .build();
  //
  //    UserDetails susan =
  //        User.builder()
  //            .username("susan")
  //            .password("{noop}1234qwer")
  //            .roles("EMPLOYEE", "MANAGER", "ADMIN")
  //            .build();
  //
  //    return new InMemoryUserDetailsManager(john, mary, susan);
  //  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeHttpRequests(
            configurer ->
                configurer
                    .requestMatchers("/")
                    .hasRole("EMPLOYEE")
                    .requestMatchers("/leaders/**")
                    .hasRole("MANAGER")
                    .requestMatchers("/systems/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated())
        .formLogin(
            form ->
                form.loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()) // allow all to access login page
        .logout(LogoutConfigurer::permitAll)
        .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

    return httpSecurity.build();
  }
}
