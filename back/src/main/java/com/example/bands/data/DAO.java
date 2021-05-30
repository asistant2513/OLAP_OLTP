package com.example.bands.data;

import java.util.List;

public interface DAO<T> {

    public List<T> getAll();

    public T getById(int id);

    public void save(T instance);

    public void update(T instance);

    public void delete(T instance);

    public void deleteById(int id);

}
