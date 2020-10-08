package com.ahoubouby.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<I extends Serializable, T> {
    I save(I entity);

    int delete(I entity);

    int delete(T id);

    List<I> selectAll();    

    Optional<I> findById(T id);

    int update(T entity);
}
