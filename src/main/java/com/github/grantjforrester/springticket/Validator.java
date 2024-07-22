package com.github.grantjforrester.springticket;

public interface Validator {

    void validate(Object o, Class<?>... groups) throws ValidationException;
}
