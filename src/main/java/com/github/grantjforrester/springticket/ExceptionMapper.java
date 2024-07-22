package com.github.grantjforrester.springticket;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException exception, WebRequest request) {
        var ex = (NotFoundException) exception;
        var body = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        body.setType(URI.create("ticket:err:notfound"));
        body.setDetail(String.format("no ticket with id %s found", ex.getId()));
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { ConflictException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
        var body = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        body.setType(URI.create("ticket:err:conflict"));
        body.setDetail("version conflict");
        return handleExceptionInternal(exception, body, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { ValidationException.class })
    protected ResponseEntity<Object> handleNotValid(RuntimeException exception, WebRequest request) {
        var body = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        body.setType(URI.create("ticket:err:badrequest"));
        body.setDetail(exception.getMessage());
        return handleExceptionInternal(exception, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
