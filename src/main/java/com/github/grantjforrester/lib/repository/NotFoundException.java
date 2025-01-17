package com.github.grantjforrester.lib.repository;

public class NotFoundException extends RuntimeException {
    private String id;

    public NotFoundException(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
