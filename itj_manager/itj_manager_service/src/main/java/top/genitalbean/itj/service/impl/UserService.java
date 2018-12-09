package top.genitalbean.itj.service.impl;

import org.springframework.stereotype.Service;
import top.genitalbean.itj.service.BaseService;

import java.util.List;

@Service
public class UserService implements BaseService {
    @Override
    public <E> boolean insert(E e) {
        return false;
    }

    @Override
    public <E> boolean update(E e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public <E> List<E> query() {
        return null;
    }
}
