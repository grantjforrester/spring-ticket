package com.github.grantjforrester.springticket;

import java.util.List;

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
public class TicketController {

    @GetMapping("/tickets")
    List<TicketWithMetadata> queryTickets() {
        return List.of(
                new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open"),
                new TicketWithMetadata("2", "1", "test-summary-2", "test-description-2", "open"));
    }

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    TicketWithMetadata createTicket(@RequestBody TicketWithMetadata ticket) {
        return ticket;
    }

    @GetMapping("/tickets/{id}")
    TicketWithMetadata readTicket(@PathVariable String id) {
        return new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open");
    }

    @PutMapping("/tickets/{id}")
    TicketWithMetadata updateTicket(@PathVariable String id, @RequestBody TicketWithMetadata ticket) {
        return ticket;
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicket(@PathVariable String id) {

    }

}
