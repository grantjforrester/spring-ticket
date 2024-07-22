package com.github.grantjforrester.springticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/api/v1/tickets")
    List<TicketWithMetadata> queryTickets() {
        return service.queryTickets();
    }

    @PostMapping("/api/v1/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    TicketWithMetadata createTicket(@RequestBody TicketWithMetadata ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping("/api/v1/tickets/{id}")
    TicketWithMetadata readTicket(@PathVariable String id) {
        return service.readTicket(id);
    }

    @PutMapping("/api/v1/tickets/{id}")
    TicketWithMetadata updateTicket(@PathVariable String id, @RequestBody TicketWithMetadata ticket) {
        return service.updateTicket(id, ticket);
    }

    @DeleteMapping("/api/v1/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicket(@PathVariable String id) {
        service.deleteTicket(id);
    }

}
