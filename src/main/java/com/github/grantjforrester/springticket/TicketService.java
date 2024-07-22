package com.github.grantjforrester.springticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.grantjforrester.lib.authz.Authorizer;
import com.github.grantjforrester.lib.authz.Operation;

@Service
public final class TicketService {

    @Autowired
    private Authorizer authorizer;

    @Autowired
    private Repository<TicketWithMetadata> repository;

    public List<TicketWithMetadata> queryTickets(QuerySpec query) {
        authorizer.isAuthorized(new Operation("QueryTickets"));

        return repository.query((Query) query);
    }

    public TicketWithMetadata createTicket(TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("CreateTicket"));

        return repository.create(ticket);
    }

    public TicketWithMetadata readTicket(String id) {
        authorizer.isAuthorized(new Operation("ReadTicket"));

        return repository.read(id);
    }

    public TicketWithMetadata updateTicket(TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("UpdateTicket"));

        return repository.update(ticket);
    }

    public void deleteTicket(String id) {
        authorizer.isAuthorized(new Operation("DeleteTicket"));

        repository.delete(id);
    }
}
