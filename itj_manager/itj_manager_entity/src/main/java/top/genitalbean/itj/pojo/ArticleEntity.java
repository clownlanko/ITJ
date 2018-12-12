package top.genitalbean.itj.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ArticleEntity {
    private Integer articleId;
    private Integer userId;
    private String title;
    private String content;
    private String[] tags;
    private Integer likeQuantity;
    private Integer lookQuantity;
    private Date createTime;
    private Date modifyTime;
}
