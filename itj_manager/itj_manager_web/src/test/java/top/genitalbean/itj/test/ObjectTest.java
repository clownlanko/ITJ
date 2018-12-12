package top.genitalbean.itj.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.FileUpload;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.service.impl.ArticleService;
import top.genitalbean.itj.service.impl.UserService;

import java.io.File;
import java.net.URISyntaxException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class ObjectTest {
    @Autowired
    ArticleService articleService;
    @Test
    public void test(){
        ArticleEntity entity = new ArticleEntity();
        entity.setUserId(0);
        entity.setTitle("java手写一个截图软件");
        entity.setContent("javaw桌面级应用，被隐藏了。");
        entity.setCreateTime(DateFormat.now());
        entity.setModifyTime(DateFormat.now());
        articleService.insert(entity);
    }

}
