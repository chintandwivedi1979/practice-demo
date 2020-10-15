package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/posts/**").permitAll()
                .pathMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
                //.pathMatchers("/posts/**").authenticated()
                //.pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
                .anyExchange().permitAll()
                .and()
                .csrf().disable()
                .build();
    }

    private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authentication, AuthorizationContext context) {
        return authentication
                .map(a -> context.getVariables().get("user").equals(a.getName()))
                .map(granted -> new AuthorizationDecision(granted));
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsRepository() {
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        });

        UserDetails user = new User("postadmin", "postadmin", roles);
        return new MapReactiveUserDetailsService(user);
    }

}
