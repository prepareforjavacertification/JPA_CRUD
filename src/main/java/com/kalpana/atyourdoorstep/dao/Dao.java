package com.kalpana.atyourdoorstep.dao;

import java.util.List;

/**
 *
 * @author Kalpana
 */
public interface Dao<T, R>  {
    
    public T insert(T t);
    public T get(R r);
    public void delete(T t);
    public List<T> getAll();
}
