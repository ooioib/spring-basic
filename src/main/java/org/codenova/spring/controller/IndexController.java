package org.codenova.spring.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    RequestMappingHandelrMapping을 쓰게 되면 HttpRequestHandler 라는 interface 를 토대로 만들면 안됨.
    POJO (Plain Old Java Object) 형태로 Handler를 정의 내리면 됨.
 */

@Controller
public class IndexController {

    @RequestMapping({"/" , "/index"})
    public ModelAndView indexHandle() {
        System.out.println("IndexHandler.index");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("msg", "Hello World");

        return mav;
    }

    @RequestMapping("/help")
    public String helpHandle() {  // view 이름만 리턴
        System.out.println("IndexHandler.help");
    return "help";
    }
}

