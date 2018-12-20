package top.genitalbean.itj.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleManage implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("ArticleManager.preHandle(...):"+request.getServletPath());
        if(request.getSession().getAttribute("user")!=null){
            return true;
        }
        return false;
    }
}
