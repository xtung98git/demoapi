package com.tungx.demoapi.repository;

import java.util.List;

public interface IBaseRepository <T, K>{
    void add(T t);

    void update(T t);

    void delete(T t);

    T getById(K k);

    List<T> getAll();

    boolean exists(K k);
}
