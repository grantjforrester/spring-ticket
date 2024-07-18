package com.github.grantjforrester.lib.authz;

public class AlwaysAuthorize implements Authorizer {

    @Override
    public void isAuthorized(Operation operation) {
        // no error - always authorized
    }

}
