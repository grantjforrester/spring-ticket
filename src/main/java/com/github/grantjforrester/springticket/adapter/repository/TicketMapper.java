package com.github.grantjforrester.springticket.adapter.repository;

import org.mapstruct.Mapper;

import com.github.grantjforrester.springticket.service.TicketWithMetadata;

@Mapper
public interface TicketMapper {

    TicketEntity ticketWithMetadataToTicketEntity(TicketWithMetadata ticket);

    TicketWithMetadata ticketEntityToTicketWithMetadata(TicketEntity entity);
}
