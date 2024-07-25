package com.github.grantjforrester.springticket.adapter.repository;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

public interface TicketCrudRepository extends ListCrudRepository<TicketEntity, UUID> {

}
