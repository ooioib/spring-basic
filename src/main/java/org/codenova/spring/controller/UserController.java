package org.codenova.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/join")
    public void joinHandle(){
        System.out.println("UserController joinHandle");
    }

    @RequestMapping("/join/proceed")
    public void joinProceedHandle(){
        System.out.println("UserController joinProceedHandle");
    }

}
