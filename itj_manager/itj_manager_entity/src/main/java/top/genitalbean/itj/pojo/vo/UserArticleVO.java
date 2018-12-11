package top.genitalbean.itj.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserArticleVO {
    private Integer userId;
    private String account;
    private String headPhoto;
    private String title;
    private String content;
    private Integer likeQuantity;
    private Integer lookQuantity;
    /**
     * 一篇文章对应多个标签
     */
    private List<String> tags;
}
