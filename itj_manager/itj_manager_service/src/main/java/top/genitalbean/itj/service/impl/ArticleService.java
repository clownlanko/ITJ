package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.genitalbean.itj.dao.mapper.ArticleMapper;
import top.genitalbean.itj.service.BaseService;

import java.util.List;

@Service
public class ArticleService implements BaseService {
    @Autowired ArticleMapper articleMapper;
    @Override
    public <E> boolean insert(E e) {
        return articleMapper.insert(e)==1;
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
