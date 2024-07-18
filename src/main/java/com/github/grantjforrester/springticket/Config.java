package com.github.grantjforrester.springticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.grantjforrester.lib.authz.AlwaysAuthorize;
import com.github.grantjforrester.lib.authz.Authorizer;

@Configuration
public class Config {

    @Bean
    public Authorizer getAuthorizer() {
        return new AlwaysAuthorize();
    }
}
