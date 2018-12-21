package top.genitalbean.itj.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.genitalbean.itj.commons.exception.NoDataMatchException;
import top.genitalbean.itj.commons.util.DateFormat;
import top.genitalbean.itj.commons.util.DigestContent;
import top.genitalbean.itj.commons.util.File4ITJ;
import top.genitalbean.itj.commons.web.ResponseResult;
import top.genitalbean.itj.pojo.UserEntity;
import top.genitalbean.itj.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user.itj")
public class UserController extends BaseController{
    private final Logger log=Logger.getLogger(UserController.class);
    @Autowired UserService userService;

    /**
     * 注册
     * @param request
     * @param account
     * @param password
     * @param headPhoto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/register.itj")
    @ResponseBody
    public ResponseResult<Void> register(HttpServletRequest request,
                                 @RequestParam("account") String account,
                                 @RequestParam("password") String password,
                                 @RequestParam(value = "headPhoto",required = false) CommonsMultipartFile headPhoto) throws IOException {
        ResponseResult<Void> result=new ResponseResult<>();
        //2.密码加密
        UserEntity user = new UserEntity(account, DigestContent.encode(password));
        user.setJoinTime(DateFormat.now());
        user.setModifyTime(DateFormat.now());
        //3.保存头像
        if(!headPhoto.isEmpty()){
            File dir = new File(request.getServletContext().getRealPath("/user_img"),
                    account);
            if(!dir.exists())
                dir.mkdir();
            //获取后缀名
            user.setHeadPhoto("user_img/"+account+"/"+File4ITJ.saveImageToFile(headPhoto,dir).getName());
        }
        //4.保存用户数据
        if(userService.insert(user)){
            result.setState(4);
            result.setMessage("注册成功，即将跳转登录页面");
            request.getSession().setAttribute("user",user);
        }
        return result;
    }

    /**
     * 登陆
     * @param session
     * @param account
     * @param password
     * @return
     * @throws NoDataMatchException
     */
    @PostMapping("/login.itj")
    @ResponseBody
    public ResponseResult<Void> login(HttpSession session,
                        @RequestParam("account") String account,
                        @RequestParam("password") String password)throws NoDataMatchException{
        ResponseResult<Void> result = new ResponseResult<>();
        try {
            session.setAttribute("user",userService.queryByUser(account, DigestContent.encode(password)));
            result.setState(4);
            result.setMessage("登陆成功，即将跳转...");
        } catch (NoDataMatchException e) {
            result.setState(-1);
            result.setMessage("你还有注册?或则用户名或密码错误!");
        }
        return result;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @GetMapping("/logout.itj")
    public String logout(HttpSession session){
        if(session.getAttribute("user")!=null){
            log.info("remove user of session");
            session.removeAttribute("user");
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
            userService.queryByAccount(account);
            result.setMessage(account+"已存在<br>请更换");
            result.setState(4);
        }catch (NoDataMatchException ex){
            log.info(ex.getMessage());
        }
        return result;
    }

    /**
     * 更改密码
     * @param user
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @PostMapping("/cp.itj")
    @ResponseBody
    public ResponseResult<Void> changePassword(@SessionAttribute("user") UserEntity user,
                                               @RequestParam("oldPwd") String oldPwd,
                                               @RequestParam("newPwd") String newPwd){
        ResponseResult<Void> result = new ResponseResult<>();
        if(user==null){
            result.setState(1);
            result.setMessage("登陆信息已过期，请重新登陆");
            return result;
        }
        if(!user.getPassword().equals(DigestContent.encode(oldPwd))){
            result.setState(-1);
            result.setMessage("原密码输入错误");
            return result;
        }
        if(userService.changePassword(user.getAccount(),DigestContent.encode(oldPwd),DigestContent.encode(newPwd))){
            result.setMessage("修改成功");
            result.setState(4);
            //更新信息
            user.setPassword(DigestContent.encode(newPwd));
        }else {
            result.setMessage("修改失败");
            result.setState(-1);
        }
        return result;
    }
    /**
     * 修改信息
     */
    @PostMapping("/updateUser.itj")
    @ResponseBody
    public ResponseResult<Void> updateUserInfo(HttpServletRequest request,
                                               @SessionAttribute(value = "user") UserEntity user,
                                               @RequestParam(value = "headPhoto",required = false) CommonsMultipartFile headPhoto,
                                               @RequestParam(value = "nickname",required = false) String nickname,
                                               @RequestParam(value = "autograph",required = false) String autograph) throws IOException {
        ResponseResult<Void> result = new ResponseResult<>();
        UserEntity userEntity = new UserEntity();
        if(nickname!=null)
            userEntity.setNickname(nickname);
        if(autograph!=null)
            userEntity.setAutograph(autograph);
        if(!headPhoto.isEmpty()){
            File dir = new File(request.getServletContext().getRealPath("/user_img"),
                    user.getAccount());
            if(!dir.exists())
                dir.mkdir();
            userEntity.setHeadPhoto("user_img/"+user.getAccount()+"/"+File4ITJ.saveImageToFile(headPhoto, dir).getName());
        }
        userEntity.setModifyTime(DateFormat.now());
        userEntity.setUserId(user.getUserId());
        if(userService.update(userEntity)){
            //更新信息
            if(nickname!=null)
                user.setNickname(nickname);
            if(autograph!=null)
                user.setAutograph(autograph);
            if(!headPhoto.isEmpty()){
                //删除之前的头像
                new File(request.getServletContext().getRealPath("/user_img"),user.getHeadPhoto()).delete();
               //更新头像
                user.setHeadPhoto(userEntity.getHeadPhoto());
            }
            result.setState(4);
            result.setMessage("修改成功");
        }else{
            result.setState(-1);
            result.setMessage("请稍后再试！");
        }
        return result;
    }
}
