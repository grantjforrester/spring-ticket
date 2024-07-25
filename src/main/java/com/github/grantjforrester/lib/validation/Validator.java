package com.github.grantjforrester.lib.validation;

public interface Validator {

    void validate(Object o, Class<?>... groups) throws ValidationException;

    void validateUUID(String id) throws ValidationException;
}
