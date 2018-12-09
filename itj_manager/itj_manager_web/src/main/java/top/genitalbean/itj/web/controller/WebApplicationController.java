package top.genitalbean.itj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebApplicationController extends BaseController{
    @RequestMapping("/{name}")
    public String toPage(@PathVariable("name") String name){
        return name;
    }
}
