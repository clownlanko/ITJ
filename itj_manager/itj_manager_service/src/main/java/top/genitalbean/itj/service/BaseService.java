package top.genitalbean.itj.service;

import java.util.List;

public interface BaseService<T> {
    boolean insert(T e);
    boolean update(T e);
    <E> boolean delete(E e);
    List<T> query();
}
