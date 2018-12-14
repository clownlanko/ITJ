package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.genitalbean.itj.dao.mapper.ArticleTagMapper;
import top.genitalbean.itj.pojo.ArticleTagEntity;
import top.genitalbean.itj.service.BaseService;

import java.util.List;

@Service
public class ArticleTagService implements BaseService<ArticleTagEntity> {
    @Autowired ArticleTagMapper articleTagMapper;

    /**
     * 插入文章标签
     * @param tags 标签
     * @return 返回知否添加成功
     */
    public boolean insertMultipartTag(ArticleTagEntity[] tags){
        return articleTagMapper.insertMultipartTag(tags)>0;
    }
    @Override
    public boolean insert(ArticleTagEntity e) {
        return articleTagMapper.insert(e)>0;
    }

    @Override
    public boolean update(ArticleTagEntity e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public List<ArticleTagEntity> query() {
        return null;
    }
}
