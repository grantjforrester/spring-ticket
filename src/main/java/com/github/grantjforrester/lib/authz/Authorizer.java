package com.github.grantjforrester.lib.authz;

public interface Authorizer {
    void isAuthorized(Operation operation);
};