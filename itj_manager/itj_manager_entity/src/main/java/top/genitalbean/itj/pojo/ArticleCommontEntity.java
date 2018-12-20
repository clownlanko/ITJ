package top.genitalbean.itj.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleCommontEntity {
    private String commontId;
    private Integer articleId;
    private Integer userId;
    private String commont;
}
