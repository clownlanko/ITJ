package top.genitalbean.itj.service;

import java.util.List;

public interface BaseService {
    <E> boolean insert(E e);
    <E> boolean update(E e);
    <E> boolean delete(E e);
    <E> List<E> query();
}
