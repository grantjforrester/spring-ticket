package com.github.grantjforrester.springticket.service;

import org.hibernate.validator.constraints.UUID;

import com.github.grantjforrester.lib.validation.Metadata;
import com.github.grantjforrester.lib.validation.Model;

import jakarta.validation.constraints.NotBlank;

public record TicketWithMetadata(
        @NotBlank(message = "missing field:", groups = Metadata.class) @UUID String id,
        @NotBlank(message = "missing field:", groups = Metadata.class) String version,
        @NotBlank(message = "missing field:", groups = Model.class) String summary,
        String description,
        @NotBlank(message = "missing field:", groups = Model.class) String status) {
}
