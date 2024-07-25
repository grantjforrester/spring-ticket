package com.github.grantjforrester.springticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.grantjforrester.lib.authz.Authorizer;
import com.github.grantjforrester.lib.authz.Operation;
import com.github.grantjforrester.lib.collection.QuerySpec;
import com.github.grantjforrester.lib.repository.Query;
import com.github.grantjforrester.lib.repository.Repository;
import com.github.grantjforrester.lib.validation.Metadata;
import com.github.grantjforrester.lib.validation.Model;
import com.github.grantjforrester.lib.validation.Validator;

@Service
public final class TicketService {

    @Autowired
    private Authorizer authorizer;

    @Autowired
    private Validator validator;

    @Autowired
    private Repository<TicketWithMetadata> repository;

    public List<TicketWithMetadata> queryTickets(QuerySpec query) {
        authorizer.isAuthorized(new Operation("QueryTickets"));
        return repository.query((Query) query);
    }

    public TicketWithMetadata createTicket(TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("CreateTicket"));
        validator.validate(ticket, Model.class);
        return repository.create(ticket);
    }

    public TicketWithMetadata readTicket(String id) {
        authorizer.isAuthorized(new Operation("ReadTicket"));
        validator.validateUUID(id);
        return repository.read(id);
    }

    public TicketWithMetadata updateTicket(TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("UpdateTicket"));
        validator.validate(ticket, Metadata.class, Model.class);
        return repository.update(ticket);
    }

    public void deleteTicket(String id) {
        authorizer.isAuthorized(new Operation("DeleteTicket"));
        validator.validateUUID(id);
        repository.delete(id);
    }
}
