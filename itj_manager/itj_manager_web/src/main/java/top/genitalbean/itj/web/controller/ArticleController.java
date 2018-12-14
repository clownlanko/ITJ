package top.genitalbean.itj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.File4ITJ;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.pojo.ArticleTagEntity;
import top.genitalbean.itj.pojo.TagEntity;
import top.genitalbean.itj.service.impl.ArticleService;
import top.genitalbean.itj.service.impl.ArticleTagService;
import top.genitalbean.itj.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ac.itj")
public class ArticleController extends BaseController{
    @Autowired ArticleService articleService;
    @Autowired TagService tagService;
    @Autowired ArticleTagService articleTagService;
    @PostMapping("/add.itj")
    @ResponseBody
    public ResponseResult<Integer> addBlog(ArticleEntity article){
        ResponseResult<Integer> result = new ResponseResult<>();
        article.setCreateTime(DateFormat.now());
        article.setModifyTime(DateFormat.now());
        //添加文章
        if(articleService.insert(article)){
            //添加标签
            if(article.getTags()!=null){
                List<TagEntity> tags=new ArrayList<>();
                for(String name:Arrays.asList(article.getTags())){
                    tags.add(new TagEntity(-1,name));
                }
                tags=tagService.insertMultipartTag(tags);
                ArticleTagEntity[] list=new ArticleTagEntity[tags.size()];
                int index=0;
                for(TagEntity tag:tags){
                    list[index++]=new ArticleTagEntity(article.getArticleId(),tag.getTagId());
                }
                //添加文章标签
                articleTagService.insertMultipartTag(list);
            }
            result.setState(4);
            result.setMessage("发布成功");
        }
        return result;
    }
    @PostMapping("/addimg.itj")
    @ResponseBody
    public ResponseResult<String> addImage(HttpServletRequest request,
                                           @RequestParam("image") CommonsMultipartFile image,
                                           @RequestParam("account") String account){
        ResponseResult<String> result = new ResponseResult<>();
        if(!image.isEmpty()){
            File dir = new File(request.getServletContext().getRealPath("/user_img"),
                    account);
            //获取后缀名
            String fileName= File4ITJ.generateFileName(image);
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
