package org.codenova.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @RequestMapping("/artcle/{id}")
    public void viewhandle(){
        System.out.println("ArticleController.viewHandle()");
    }
}
