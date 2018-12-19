package top.genitalbean.itj.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserArticleVO{
    private Integer articleId;
    private Integer userId;
    private String nickname;
    private String title;
    private String content;
    private Integer likeQuantity;
    private Integer lookQuantity;
    private Date createTime;
    private Date modifyTime;
    /**
     * 一篇文章对应多个标签
     */
    private List<String> tags;
    private List<String> commonts;
}
