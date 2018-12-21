package top.genitalbean.itj.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.genitalbean.itj.dao.BaseMapper;
import top.genitalbean.itj.pojo.vo.UserArticleVO;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends BaseMapper {
    List<UserArticleVO> queryByUserId(Integer userId);
    UserArticleVO queryByArticleId(Integer articleId);
    Integer updateLookQuantity(Integer articleId);
    Integer updateLikeQuantity(Integer articleId);
    List<UserArticleVO> queryArticles();
    void deleteArticle(Map<String,Integer> map);
    List<UserArticleVO> queryArticleByKeyword(String keyword);
}
