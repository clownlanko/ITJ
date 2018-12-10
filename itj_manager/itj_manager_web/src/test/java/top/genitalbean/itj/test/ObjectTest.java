package top.genitalbean.itj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.genitalbean.itj.commons.util.FileUpload;
import top.genitalbean.itj.service.impl.UserService;

import java.io.File;
import java.net.URISyntaxException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class ObjectTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        System.out.println(userService.queryByAccount("admin"));
    }
}
