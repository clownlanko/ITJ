package top.genitalbean.itj.dao.mapper;

import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.ArticleTagEntity;

public interface ArticleTagMapper extends BaseMapper{
    Integer insertMultipartTag(ArticleTagEntity[] tags);
}
