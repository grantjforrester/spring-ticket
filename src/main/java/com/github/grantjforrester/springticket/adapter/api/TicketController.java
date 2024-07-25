package com.github.grantjforrester.springticket.adapter.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.grantjforrester.lib.collection.Cql;
import com.github.grantjforrester.springticket.service.TicketService;
import com.github.grantjforrester.springticket.service.TicketWithMetadata;

@RestController
public final class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/api/v1/tickets")
    List<TicketWithMetadata> queryTickets(@RequestParam MultiValueMap<String, String> params) {
        var query = Cql.parseQuery(params);
        return service.queryTickets(query);
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
        var sntzd = new TicketWithMetadata(id, ticket.version(), ticket.summary(), ticket.description(),
                ticket.status());
        return service.updateTicket(sntzd);
    }

    @DeleteMapping("/api/v1/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicket(@PathVariable String id) {
        service.deleteTicket(id);
    }

}
