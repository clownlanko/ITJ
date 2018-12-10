package top.genitalbean.itj.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class BaseController {
    @RequestMapping("/{name}")
    public String toPage(@PathVariable("name") String name){
        return name;
    }
}
