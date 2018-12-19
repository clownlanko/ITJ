package top.genitalbean.itj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.DigestContent;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.pojo.ArticleTagEntity;
import top.genitalbean.itj.pojo.TagEntity;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.pojo.vo.UserArticleVO;
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
    @Autowired UserService userService;
    @Test
    public void test(){
        System.err.println(articleService.queryArticles());
    }

}
