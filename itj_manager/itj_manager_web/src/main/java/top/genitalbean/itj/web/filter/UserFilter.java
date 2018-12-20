package top.genitalbean.itj.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userFilter",urlPatterns = {"/view/editor.jsp","/view/zero.jsp"})
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        System.err.println("UserFilter.doFilter(...):"+request.getServletPath());
        if(request.getSession().getAttribute("user")!=null){
           filterChain.doFilter(request,response);
        }else {
            StringBuffer content=new StringBuffer();
            content.append("<!DOCTYPE html>");
            content.append("<html lang='zh_cn'>");
            content.append("<head>");
            content.append("<meta charset='UTF-8'>");
            content.append("<script src='/ITJ/js/jquery-2.1.4.min.js'></script>");
            content.append("<script src='/ITJ/layer/layer.js'></script>");
            content.append("<style>body{margin:0px;}</style>");
            content.append("</head>");
            content.append("<body>");
            content.append("<canvas id='coderain' style='background:#111'></canvas>");
            content.append("<script src='/ITJ/js/coderain.js'></script>");
            content.append("<script>");
            content.append("draw('ITJ博客');");
            content.append("layer.alert('你没有权限，或者登陆信息已过期。<br>即将跳转登陆页面...',{icon:2,title:'ITJ提示',end:function(){location.href='login.jsp'}});");
            content.append("</script>");
            content.append("</body>");
            content.append("</html>");
            ServletOutputStream out = response.getOutputStream();
            out.write(content.toString().getBytes("UTF-8"));
            out.close();
        }
    }
}
