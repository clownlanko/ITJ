package top.genitalbean.itj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.DigestContent;
import top.genitalbean.itj.commons.util.File4ITJ;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user.itj")
public class UserController extends BaseController{
    @Autowired UserService userService;
    @PostMapping(value = "/register.itj")
    @ResponseBody
    public ResponseResult<Void> register(HttpServletRequest request,
                                 @RequestParam("account") String account,
                                 @RequestParam("password") String password,
                                 @RequestParam(value = "headPhoto",required = false) CommonsMultipartFile headPhoto) throws IOException {
        ResponseResult<Void> result=new ResponseResult<>();
        //1.查询是否已有此用户名
        try{
            userService.queryByAccount(account);
            result.setState(3);
            result.setMessage(account+"已存在");
        }catch (NoDataMatchException ex){
            //2.密码加密
            UserEntity user = new UserEntity(account, DigestContent.encode(password));
            user.setJoinTime(DateFormat.now());
            user.setModifyTime(DateFormat.now());
            user.setHeadPhoto("img/account.png");
            //3.保存头像
            if(!headPhoto.isEmpty()){
                File dir = new File(request.getServletContext().getRealPath("/user_img"),
                        account);
                if(!dir.exists())
                    dir.mkdir();
                //获取后缀名
                String fileName = File4ITJ.generateFileName(headPhoto);
                File file = new File(dir, fileName);
                headPhoto.transferTo(file);
                user.setHeadPhoto("user_img/"+account+"/"+fileName);
            }
            //4.保存用户数据
            if(userService.insert(user)){
                result.setState(4);
                result.setMessage("注册成功，即将跳转登录页面");
                request.getSession().setAttribute("user",user);
            }
        }
        return result;
    }
    @RequestMapping("/login.itj")
    public String login(HttpSession session,
                        @RequestParam("account") String account,
                        @RequestParam("password") String password){
        UserEntity user = userService.queryByUser(account, DigestContent.encode(password));
        //1.判断session中是否已有数据
        if(user.equals(session.getAttribute("user"))){
            return "zero";
        }
        if(user!=null){
            session.setAttribute("user",user);
            return "zero";
        }
        return "login";
    }

    /**
     * 注册用户时判断用户名
     * @param account 用户名
     * @return 返回是否存在消息
     */
    @ResponseBody
    @GetMapping("/qa.itj")
    public ResponseResult<Void> queryAccount(@RequestParam("account") String account){
        ResponseResult<Void> result = new ResponseResult<>();
        try{
            userService.queryByAccount(account).getHeadPhoto();
            result.setMessage(account+"已存在<br>请更换");
            result.setState(4);
        }catch (NoDataMatchException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
