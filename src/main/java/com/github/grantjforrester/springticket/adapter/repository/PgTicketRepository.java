package com.github.grantjforrester.springticket.adapter.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import com.github.grantjforrester.lib.repository.ConflictException;
import com.github.grantjforrester.lib.repository.NotFoundException;
import com.github.grantjforrester.lib.repository.Query;
import com.github.grantjforrester.lib.repository.Repository;
import com.github.grantjforrester.springticket.service.TicketWithMetadata;

public class PgTicketRepository implements Repository<TicketWithMetadata> {

    @Autowired
    private TicketCrudRepository repository;

    @Override
    public TicketWithMetadata create(TicketWithMetadata ticket) {
        return repository.save(TicketEntity.fromTicket(ticket)).toTicket();
    }

    @Override
    public TicketWithMetadata read(String id) throws NotFoundException {
        var entity = repository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException(id));
        return entity.toTicket();
    }

    @Override
    public TicketWithMetadata update(TicketWithMetadata ticket) throws NotFoundException, ConflictException {
        repository.findById(UUID.fromString(ticket.id())).orElseThrow(() -> new NotFoundException(ticket.id()));
        try {
            var entity = repository.save(TicketEntity.fromTicket(ticket));
            return entity.toTicket();
        } catch (ObjectOptimisticLockingFailureException e) {
            throw new ConflictException();
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<TicketWithMetadata> query(Query query) {
        return repository.findAll().stream().map(mapper::ticketEntityToTicketWithMetadata).toList();
    }

}
