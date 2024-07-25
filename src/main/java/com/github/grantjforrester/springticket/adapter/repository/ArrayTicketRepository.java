package com.github.grantjforrester.springticket.adapter.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.grantjforrester.lib.repository.ConflictException;
import com.github.grantjforrester.lib.repository.NotFoundException;
import com.github.grantjforrester.lib.repository.Repository;
import com.github.grantjforrester.springticket.service.TicketWithMetadata;

public class ArrayTicketRepository implements Repository<TicketWithMetadata> {

    private ArrayList<TicketWithMetadata> storage = new ArrayList<TicketWithMetadata>();

    @Override
    public TicketWithMetadata create(TicketWithMetadata ticket) {
        var id = UUID.randomUUID();
        var entity = new TicketWithMetadata(id.toString(), "0", ticket.summary(), ticket.description(),
                ticket.status());
        storage.add(entity);
        return entity;
    }

    @Override
    public TicketWithMetadata read(String id) throws NotFoundException {
        return storage.stream().filter(e -> e.id().equals(id)).findFirst()
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public TicketWithMetadata update(TicketWithMetadata ticket) throws NotFoundException, ConflictException {
        var entity = read(ticket.id());

        if (!entity.version().equals(ticket.version()))
            throw new ConflictException();

        var idx = storage.indexOf(entity);
        var newVer = Integer.parseInt(ticket.version()) + 1;
        var updatedEntity = new TicketWithMetadata(ticket.id(), Integer.toString(newVer), ticket.summary(),
                ticket.description(), ticket.status());
        storage.set(idx, updatedEntity);
        return updatedEntity;
    }

    @Override
    public void delete(String id) throws NotFoundException {
        try {
            var entity = read(id);
            storage.remove(entity);
        } catch (NotFoundException ex) {
            // Nothing to delete
        }
    }

    @Override
    public List<TicketWithMetadata> query(com.github.grantjforrester.lib.repository.Query query) {
        // TODO Auto-generated method stub
        return List.of(
                new TicketWithMetadata("1", "1", "test-summary-1", "test-description-1", "open"),
                new TicketWithMetadata("2", "1", "test-summary-2", "test-description-2", "open"));
    }
}
