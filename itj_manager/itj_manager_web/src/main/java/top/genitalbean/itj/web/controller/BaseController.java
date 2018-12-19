package top.genitalbean.itj.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.genitalbean.itj.commons.exception.NoDataMatchException;

public abstract class BaseController {
    @RequestMapping("/{path}")
    public String toPage(@PathVariable("path") String path){
        return path;
    }
    @ExceptionHandler(NoDataMatchException.class)
    public String handNoDataMatch(ModelMap map,NoDataMatchException ex){
        map.addAttribute("message",ex.getMessage());
        return "404";
    }
}
