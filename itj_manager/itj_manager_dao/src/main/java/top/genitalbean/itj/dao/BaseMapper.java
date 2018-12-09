package top.genitalbean.itj.dao;

import java.util.List;

public interface BaseMapper {
    <E> Integer insert(E e);
    <E> Integer update(E e);
    <E> Integer delete(E e);
    <E> List<E> query();
}
