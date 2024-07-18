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
    List<String> queryTickets() {
        return List.of("foo", "bar", "baz");
    }

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    String createTicket(@RequestBody String ticket) {
        return ticket;
    }

    @GetMapping("/tickets/{id}")
    String readTicket(@PathVariable String id) {
        return id;
    }

    @PutMapping("/tickets/{id}")
    String updateTicket(@PathVariable String id, @RequestBody String ticket) {
        return ticket;
    }

    @DeleteMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTicket(@PathVariable String id) {

    }

}
