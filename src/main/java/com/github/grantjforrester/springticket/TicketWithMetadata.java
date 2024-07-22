package com.github.grantjforrester.springticket;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotBlank;

public record TicketWithMetadata(
        @NotBlank(message = "missing field:", groups = Metadata.class) @UUID String id,
        @NotBlank(message = "missing field:", groups = Metadata.class) String version,
        @NotBlank(message = "missing field:", groups = Model.class) String summary,
        String description,
        @NotBlank(message = "missing field:", groups = Model.class) String status) {
}
