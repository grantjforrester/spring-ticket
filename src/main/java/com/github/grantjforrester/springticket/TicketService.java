package com.github.grantjforrester.springticket;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public final class TicketService {

    public List<TicketWithMetadata> queryTickets() {
        return List.of(
                new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open"),
                new TicketWithMetadata("2", "1", "test-summary-2", "test-description-2", "open"));
    }

    public TicketWithMetadata createTicket(TicketWithMetadata ticket) {
        return ticket;
    }

    public TicketWithMetadata readTicket(String id) {
        return new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open");
    }

    public TicketWithMetadata updateTicket(String id, TicketWithMetadata ticket) {
        return ticket;
    }

    public void deleteTicket(String id) {

    }
}
