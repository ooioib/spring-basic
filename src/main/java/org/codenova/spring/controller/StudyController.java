package org.codenova.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    @RequestMapping이 적용된 메서드는 메서드의 매개변수(인자)와 반환 타입을 다양하게 설정할 수 있다
    매개변수 부분부터 살펴보자.
 */
@Controller
@RequestMapping("/study")
public class StudyController {

    /*
        HttpServletRequest, HttpServletResponse, HttpSession  : servlet-api 에서 사용하던 객체를 직접 제어하고자 할 때
     */
    @RequestMapping("/one")
    public void studyOneHandle(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        HttpSession s = req.getSession();
        System.out.println(s == session);
    }

    /*
       Model , ModelMap : 뷰로 데이터를 전달하고자 할 때
        - For access to the model that is used in HTML controllers and exposed to templates as part of view rendering.
        - Spring에서는 Model 또는 ModelMap 객체를 사용하여 데이터를 템플릿으로 전달할수 있다.
     */
    @RequestMapping("/two")
    public String studyTwoHandle(Model model) {
        System.out.println("StudyController.studyTwoHandle()");

        model.addAttribute("msg", "Hello Spring");

        return "study/two";
    }

    /*
        @RequestParam : 특정파라마티를 바로 추출하고자 할때
     */
    @RequestMapping("/three")      // /study/three?code=___&size=___
    public void studyThreeHandle(@RequestParam("code") String code, @RequestParam("size") int size) {
        System.out.println("StudyController.studyThreeHandle");
        System.out.println("code = " + code);
        System.out.println("code = " + size);

    }
}
