package com.github.grantjforrester.lib.validation;

import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

public class BeanValidator implements Validator {

    private jakarta.validation.Validator validator;

    public BeanValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public void validate(Object o, Class<?>... groups) throws ValidationException {
        var errs = validator.validate(o, groups);
        if (errs.isEmpty())
            return;
        throw new ValidationException(formatValidationErrors(errs));
    }

    @Override
    public void validateUUID(String id) throws ValidationException {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new ValidationException("invalid ticket id: " + id);
        }
    }

    private String formatValidationErrors(Set<ConstraintViolation<Object>> errors) {
        var jnr = new StringJoiner(",");
        for (var v : errors) {
            jnr.add(v.getMessage() + " " + v.getPropertyPath());
        }
        return jnr.toString();
    }

}
