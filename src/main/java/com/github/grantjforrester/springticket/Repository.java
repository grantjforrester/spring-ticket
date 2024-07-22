package com.github.grantjforrester.springticket;

import java.util.List;

public interface Repository<T> {
    T create(T entity);

    T read(String id) throws NotFoundException;

    T update(T entity) throws NotFoundException, ConflictException;

    void delete(String id) throws NotFoundException;

    List<T> query(Query query);
}
