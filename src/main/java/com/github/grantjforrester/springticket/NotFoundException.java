package com.github.grantjforrester.springticket;

public class NotFoundException extends RuntimeException {
    private String id;

    public NotFoundException(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
