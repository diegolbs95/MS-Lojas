package com.diego.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
//@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore tokenStore;

    public static final String[] ROLE_PUBLIC = {"/autorizacao/login"};
    public static final String[] ROLE_OPERADOR = {"/produto/**"};
    public static final String [] ROLE_ADMIN = {"/usuario/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(ROLE_PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, ROLE_OPERADOR).hasAnyRole("OPERADOR", "ADMIN")
                .antMatchers(ROLE_ADMIN).hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }
}
