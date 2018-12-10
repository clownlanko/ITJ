package top.genitalbean.itj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.DigestContent;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user.itj")
@SessionAttributes(names = {"user"},types = {UserEntity.class})
public class UserController extends BaseController{
    @Autowired
    UserService userService;
    @PostMapping(value = "/register.itj")
    public String register(HttpServletRequest request,
                             @RequestParam("account") String account,
                             @RequestParam("password") String password,
                             @RequestParam("headPhoto") CommonsMultipartFile headPhoto) throws IOException {
//        //1.查询是否已有此用户名
//        try{
//            userService.queryByAccount(account);
//        }catch (NoDataMatchException ex){
//            //2.密码加密
//            UserEntity user = new UserEntity(account, DigestContent.encode(password));
//            //3.保存头像
//            if(!headPhoto.isEmpty()){
//                File dir = new File(request.getServletContext().getRealPath("/user_img"),
//                        account);
//                if(!dir.exists())
//                    dir.mkdir();
//                //获取后缀名
//                String suffix = headPhoto.getOriginalFilename();
//                suffix=suffix.substring(suffix.lastIndexOf('.'));
//                String fileName = System.currentTimeMillis() + "_" + headPhoto.getSize() + suffix;
//                File file = new File(dir, fileName);
//                headPhoto.transferTo(file);
//                user.setHeadPhoto("user_img/"+account+"/"+fileName);
//                user.setJoinTime(DateFormat.now());
//                user.setModifyTime(DateFormat.now());
//            }
//            //4.保存用户数据
//            if(userService.insert(user)){
//                //5.session存值
//                request.getSession().setAttribute("user",user);
//            }
//        }
        return "redirect:login";
    }
//    public ResponseResult<UserEntity> login(String account){}
}
