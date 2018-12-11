package top.genitalbean.itj.dao.mapper;

import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.vo.UserArticleVO;

import java.util.List;

public interface UserArticleMapper extends BaseMapper {
    List<UserArticleVO> findByAccountOrTitle(String content);
}
