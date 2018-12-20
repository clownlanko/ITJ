package top.genitalbean.itj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.genitalbean.itj.service.impl.ArticleService;
import top.genitalbean.itj.service.impl.ArticleTagService;
import top.genitalbean.itj.service.impl.TagService;
import top.genitalbean.itj.service.impl.UserService;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class ObjectTest {
    @Autowired ArticleService articleService;
    @Test
    public void test(){
        System.err.println(articleService.queryArticleByKeyword("客测"));
    }

}
