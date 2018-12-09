package top.genitalbean.itj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.util.FileUpload;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.UserEntity;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/user.itj")
//@SessionAttributes(names = {"user"},types = {UserEntity.class})
public class UserController extends BaseController{
    @ResponseBody
    @PostMapping("/register.itj")
    public ResponseResult<Void> register(HttpSession session,
                                         @RequestParam("account") String account,
                                         @RequestParam("password") String password,
                                         @RequestParam("headPhoto") CommonsMultipartFile headPhoto) {
        ResponseResult<Void> result = new ResponseResult<>();
        UserEntity user = new UserEntity(account, password);
        user.setHeadPohot(headPhoto.getName());
//        session.setAttribute("user",user);
        System.err.println(user);
        try {
            System.out.println(new FileUpload().saveFile(account,null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
