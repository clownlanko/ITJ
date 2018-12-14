package top.genitalbean.itj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.pojo.ArticleTagEntity;
import top.genitalbean.itj.pojo.TagEntity;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.service.impl.ArticleService;
import top.genitalbean.itj.service.impl.ArticleTagService;
import top.genitalbean.itj.service.impl.TagService;
import top.genitalbean.itj.service.impl.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class ObjectTest {
    @Autowired ArticleService articleService;
    @Autowired TagService tagService;
    @Autowired ArticleTagService articleTagService;
    @Test
    public void test(){
        List<TagEntity> list=new ArrayList<>();
        list.add(new TagEntity(-1,"java"));
        list.add(new TagEntity(-1,"JAVA"));
        list.add(new TagEntity(-1,"IDEA"));
        list.add(new TagEntity(-1,"Eclipse"));
        list.add(new TagEntity(-1,"Oracle"));
        list.add(new TagEntity(-1,"wecat-app"));
        list.add(new TagEntity(-1,"易语言"));
        list=tagService.insertMultipartTag(list);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(list.toString());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ArticleTagEntity[] tags={
                new ArticleTagEntity(1,1),
                new ArticleTagEntity(1,2),
                new ArticleTagEntity(1,3),
                new ArticleTagEntity(1,4),
                new ArticleTagEntity(1,5),
                new ArticleTagEntity(1,6)
        };
//        articleTagService.insertMultipartTag(tags);
    }

}
