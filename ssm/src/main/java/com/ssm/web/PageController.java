package com.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 通用的页面跳转请求
     * @param page
     * @return
     */
    @RequestMapping("/page/{xxx}")
    public String go(@PathVariable("xxx") String page){
        System.out.println("page:"+page);
        return page;
    }
}
