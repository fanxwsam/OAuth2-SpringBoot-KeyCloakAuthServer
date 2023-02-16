package com.apps.appsdeveloperblog.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/v1/api/users/status/check")
//                .hasAuthority("SCOPE_profile")
//                .anyRequest().authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//    }


//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/v1/api/photos/protected")
//            .hasAuthority("SCOPE_protectedphotolist")
//            .anyRequest().authenticated()
//            .and()
//            .oauth2ResourceServer()
//            .jwt();
//    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v1/api/photos/protected")
                //.hasAuthority("SCOPE_protectedphotolist")
                //.hasRole("developer")
                .hasAuthority("ROLE_developer")
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);
    }


}
