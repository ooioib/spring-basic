package org.codenova.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    RequestMappingHandlerMapping을 쓰게 되면 HttpRequestHandler라는 interface를 토대로 만들면 안됨
    POJO (Plain Old Java Object) 형태로 Handler를 정의 내리면 됨
 */

@Controller
public class IndexController {

    @RequestMapping({"/" , "index"})
    public void indexHandler() {
        System.out.println("IndexHandler.index");
    }

    @RequestMapping("/help")
    public void helpHandler(){
        System.out.println("IndexHandler.help");
    }
}
