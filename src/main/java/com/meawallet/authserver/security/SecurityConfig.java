package com.meawallet.authserver.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final RSAKeyUtil rsaKeyUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(
                        oauth2ResourceServerCustomizer ->
                                oauth2ResourceServerCustomizer.jwt().jwkSetUri("http://localhost:9090/oauth2/jwks"))
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        UserDetails userDetails = User
                .withUsername("user")
                .password("password")
                .authorities("read")
                .build();

        userDetailsService.createUser(userDetails);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
