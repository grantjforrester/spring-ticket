package com.github.grantjforrester.springticket.adapter.api;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class Api {

    @GetMapping(value = "/openapi.yml", produces = "application/yaml")
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/openapi.yml");
        return IOUtils.toByteArray(in);
    }

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    void health() {
    }

}
