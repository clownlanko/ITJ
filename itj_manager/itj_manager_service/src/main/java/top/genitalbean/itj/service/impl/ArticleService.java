package top.genitalbean.itj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.genitalbean.itj.dao.mapper.ArticleMapper;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.pojo.vo.UserArticleVO;
import top.genitalbean.itj.service.BaseService;

import java.util.List;

@Service
public class ArticleService implements BaseService<ArticleEntity> {
    @Autowired ArticleMapper articleMapper;
    @Override
    public boolean insert(ArticleEntity e) {
        articleMapper.insert(e);
        return e.getArticleId()>0;
    }
    public UserArticleVO queryByArticleId(Integer articleId){
        return articleMapper.queryByArticleId(articleId);
    }
    public List<UserArticleVO> queryByUserId(Integer userId){
        return articleMapper.queryByUserId(userId);
    }
    public boolean updateLookQuantity(Integer articleId){
        return articleMapper.updateLookQuantity(articleId)==1;
    }
    public boolean updateLikeQuantity(Integer articleId){return articleMapper.updateLikeQuantity(articleId)==1;}
    @Override
    public boolean update(ArticleEntity e) {
        return false;
    }

    @Override
    public <E> boolean delete(E e) {
        return false;
    }

    @Override
    public List<ArticleEntity> query() {
        return null;
    }
    public List<UserArticleVO> queryArticles(){
        return articleMapper.queryArticles();
    }
}
