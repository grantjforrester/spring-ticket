package com.github.grantjforrester.springticket;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.grantjforrester.lib.authz.AlwaysAuthorize;
import com.github.grantjforrester.lib.authz.Authorizer;
import com.github.grantjforrester.lib.repository.Repository;
import com.github.grantjforrester.lib.validation.BeanValidator;
import com.github.grantjforrester.lib.validation.Validator;
import com.github.grantjforrester.springticket.adapter.repository.PgTicketRepository;
import com.github.grantjforrester.springticket.adapter.repository.TicketMapper;
import com.github.grantjforrester.springticket.service.TicketWithMetadata;

@Configuration
public class Config {

    @Bean
    public Authorizer getAuthorizer() {
        return new AlwaysAuthorize();
    }

    @Bean
    public Validator getValidator() {
        return new BeanValidator();
    }

    @Bean
    public Repository<TicketWithMetadata> Repository() {
        return new PgTicketRepository();
    }

    @Bean
    public TicketMapper getTicketMapper() {
        return Mappers.getMapper(TicketMapper.class);
    }
}
