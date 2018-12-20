package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.genitalbean.itj.dao.mapper.ArticleCommontMapper;
import top.genitalbean.itj.pojo.ArticleCommontEntity;
import top.genitalbean.itj.service.BaseService;

import java.util.List;

@Service
public class ArticleCommontService implements BaseService<ArticleCommontEntity> {
    @Autowired private ArticleCommontMapper articleCommontMapper;
    @Override
    public boolean insert(ArticleCommontEntity e) {
        return articleCommontMapper.insert(e)==1;
    }

    @Override
    public boolean update(ArticleCommontEntity e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public List<ArticleCommontEntity> query() {
        return null;
    }
}
