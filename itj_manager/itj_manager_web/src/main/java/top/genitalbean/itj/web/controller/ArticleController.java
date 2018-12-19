package top.genitalbean.itj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.File4ITJ;
import top.genitalbean.itj.commons.web.ImageResult;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.ArticleEntity;
import top.genitalbean.itj.pojo.ArticleTagEntity;
import top.genitalbean.itj.pojo.TagEntity;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.pojo.vo.UserArticleVO;
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
public class ArticleController extends BaseController {
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleTagService articleTagService;

    /**
     * 添加博客
     *
     * @param user
     * @param article
     * @return
     */
    @PostMapping("/add.itj")
    @ResponseBody
    public ResponseResult<Integer> addBlog(@SessionAttribute("user") UserEntity user, ArticleEntity article) {
        ResponseResult<Integer> result = new ResponseResult<>();
        article.setUserId(user.getUserId());
        article.setCreateTime(DateFormat.now());
        article.setModifyTime(DateFormat.now());
        boolean flag = false;
        //添加文章
        if (articleService.insert(article)) {
            flag = true;
            //添加标签
            if (article.getTags()!=null && article.getTags().length>0) {
                List<TagEntity> tags = new ArrayList<>();
                for (String name : Arrays.asList(article.getTags())) {
                    tags.add(new TagEntity(-1, name));
                }
                tags = tagService.insertMultipartTag(tags);
                ArticleTagEntity[] list = new ArticleTagEntity[tags.size()];
                int index = 0;
                for (TagEntity tag : tags) {
                    list[index++] = new ArticleTagEntity(article.getArticleId(), tag.getTagId());
                }
                //添加文章标签
                if (!articleTagService.insertMultipartTag(list))
                    flag = false;
            }
            result.setState(4);
            result.setMessage("发布成功");
            result.setData(article.getArticleId());
        }
        if (!flag) {
            result.setState(-1);
            result.setMessage("发布失败，请稍后再试！");
        }
        return result;
    }

    /**
     * 博客添加图片
     *
     * @param request
     * @param image
     * @param account
     * @return
     * @throws IOException
     */
    @PostMapping("/addimg.itj")
    @ResponseBody
    public ImageResult addImage(HttpServletRequest request,
                                @RequestParam("editormd-image-file") CommonsMultipartFile image,
                                @RequestParam("account") String account) throws IOException {
        ImageResult result = new ImageResult();
        if (!image.isEmpty()) {
            File dir = new File(request.getServletContext().getRealPath("/user_img"),
                    account);
            File file = File4ITJ.saveImageToFile(image, dir);
            if (file.exists()) {
                result.setSuccess(1);
                System.err.println("radd:" + request.getLocalAddr());
                System.err.println("ru:" + request.getLocalName());
                System.out.println("rust:" + request.getLocalPort());
                result.setUrl("user_img/" + account + "/" + file.getName());
            } else {
                result.setSuccess(0);
                result.setMessage("上传失败");
            }
        } else {
            result.setSuccess(0);
            result.setMessage("请稍后再试");
        }
        return result;
    }

    /**
     * 根据用户ID查询用户博客
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @GetMapping("/getArticle.itj")
    public ResponseResult<List<UserArticleVO>> getArticleByUserId(@RequestParam("userId") Integer userId) {
        ResponseResult<List<UserArticleVO>> result = new ResponseResult<>();
        List<UserArticleVO> articles = articleService.queryByUserId(userId);
        if (articles.isEmpty()) {
            result.setState(-1);
            result.setMessage("你还没有写过博客，立马写？");
        } else {
            result.setData(articles);
            result.setState(4);
        }
        return result;
    }

    /**
     * 查阅文章
     *
     * @param articleId
     * @return
     */
    @GetMapping("/qa.itj")
    @ResponseBody
    public ResponseResult<UserArticleVO> getArticleBuArticleId(@SessionAttribute("user") UserEntity user,
                                                    @RequestParam("articleId") Integer articleId) {
        UserArticleVO article = articleService.queryByArticleId(articleId);
        if (user.getUserId() != article.getUserId()) {
            //如果不是本人，查阅数+1
            if (!articleService.updateLookQuantity(articleId))
                articleService.updateLookQuantity(article.getArticleId());
        }
        return new ResponseResult<>(4, article);
    }

    @GetMapping("/tu.itj")
    @ResponseBody
    public ResponseResult<Void> thumbsUp(@SessionAttribute("user") UserEntity user,
                                         @RequestParam("articleId") Integer articleId) {
        ResponseResult<Void> result = new ResponseResult<>();
        if (articleService.queryByArticleId(articleId).getUserId() != user.getUserId()) {
            if(articleService.updateLikeQuantity(articleId)){
                result.setState(4);
                result.setMessage("点赞成功");
                return result;
            }
        }
        result.setState(-1);
        result.setMessage("请稍后再试！");
        return result;
    }
    @GetMapping("/ga.itj")
    @ResponseBody
    public ResponseResult<List<UserArticleVO>> getArticles(){
        ResponseResult<List<UserArticleVO>> result = new ResponseResult<>();
        result.setData(articleService.queryArticles());
        result.setState(4);
        return result;
    }
}
