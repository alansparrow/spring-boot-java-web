package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
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
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    // Find users
    jdbcUserDetailsManager.setUsersByUsernameQuery(
        "select user_id, pw, active from members where user_id=?");

    // Find roles
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
        "select user_id, role from roles where user_id=?");

    return jdbcUserDetailsManager;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
        configure ->
            configure
                .requestMatchers(HttpMethod.GET, "/api/employees")
                .hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**")
                .hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees")
                .hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees/**")
                .hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**")
                .hasRole("ADMIN"));

    httpSecurity.httpBasic(Customizer.withDefaults());

    // In general, CSRF is not required for stateless REST APIs that use CRUD methods.
    // CSRF is normally required for browser base communication.
    httpSecurity.csrf(csrf -> csrf.disable());

    return httpSecurity.build();
  }
}
