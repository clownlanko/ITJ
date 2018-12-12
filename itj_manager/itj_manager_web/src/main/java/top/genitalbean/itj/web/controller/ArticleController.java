package top.genitalbean.itj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.service.impl.ArticleService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/ac.itj")
public class ArticleController extends BaseController{
    @Autowired ArticleService articleService;
    @RequestMapping("/add.itj")
    @ResponseBody
    public ResponseResult<Integer> addBlog(ArticleEntity article){
        ResponseResult<Integer> result = new ResponseResult<>();
        article.setCreateTime(DateFormat.now());
        article.setModifyTime(DateFormat.now());
        System.out.println(article);
        return result;
    }
    @PostMapping("/addimg.itj")
    @ResponseBody
    public ResponseResult<String> addImage(HttpServletRequest request,CommonsMultipartFile image, String account){
        ResponseResult<String> result = new ResponseResult<>();
        if(!image.isEmpty()){
            File dir = new File(request.getServletContext().getRealPath("/user_img"),
                    account);
            //获取后缀名
            String suffix = image.getOriginalFilename();
            suffix=suffix.substring(suffix.lastIndexOf('.'));
            String fileName = System.currentTimeMillis() + "_" + image.getSize() + suffix;
            File file = new File(dir, fileName);
            try {
                image.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(file.exists()){
                result.setState(4);
                result.setData("user_img/"+account+"/"+fileName);
            }else{
                result.setState(3);
                result.setMessage("上传失败");
            }
        }else{
            result.setState(-1);
            result.setMessage("请稍后再试");
        }
        return result;
    }
}
