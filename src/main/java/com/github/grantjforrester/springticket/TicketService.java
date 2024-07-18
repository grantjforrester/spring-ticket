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

    public List<TicketWithMetadata> queryTickets() {
        authorizer.isAuthorized(new Operation("QueryTickets"));

        return List.of(
                new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open"),
                new TicketWithMetadata("2", "1", "test-summary-2", "test-description-2", "open"));
    }

    public TicketWithMetadata createTicket(TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("CreateTicket"));

        return ticket;
    }

    public TicketWithMetadata readTicket(String id) {
        authorizer.isAuthorized(new Operation("ReadTicket"));

        return new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open");
    }

    public TicketWithMetadata updateTicket(String id, TicketWithMetadata ticket) {
        authorizer.isAuthorized(new Operation("UpdateTicket"));

        return ticket;
    }

    public void deleteTicket(String id) {
        authorizer.isAuthorized(new Operation("DeleteTicket"));
    }
}
