package de.erdlet.libertydemo.common.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {

    List<T> findAll();

    Optional<T> findById(final ID id);

    T persist(final T t);

    T merge(final T t);

    void remove(final T t);

}

