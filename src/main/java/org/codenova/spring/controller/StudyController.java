package org.codenova.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.codenova.spring.model.TravelSchedule;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


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
    @RequestMapping("/three")   // /study/three?code=___&size=___
    public void studyThreeHandle(@RequestParam("code") String code, @RequestParam("size") int size) {

        System.out.println("StudyController.studyThreeHandle");
        System.out.println("code = " + code);
        System.out.println("code = " + size);
    }


    @RequestMapping("/four")   // /study/four?titleId=___&sort=(ASC/DESC))&page___
    public void studyFourHandle(@RequestParam("titleId") @Nullable int titleId,
                                @RequestParam("sort") @Nullable String sort,
                                @RequestParam("page") @Nullable Integer page) {

        System.out.println("StudyController.studyFourHandle()");
        System.out.println("titleId = " + titleId);

        sort = (sort == null) ? "DESC" : sort;
        page = (page == null) ? 1 : page;

        System.out.println("sort = " + sort);
        System.out.println("page = " + page);
    }

    /*
        @RequestParam을 설정하면 필수 파라미터로 처리된다. 만약 안 넘어와도 되는 파라미터라면 추가처리가 필요함
         이 Optional 한 파라미터를 설정하는 방법은 여러가지가 있다.
    */
    @RequestMapping("/five")
    public void studyFiveHandle(@RequestParam("titleId") @Nullable int titleId,
                                @RequestParam("sort") Optional<String> sort,
                                @RequestParam("page") Optional<Integer> page) {

        System.out.println("StudyController.studyFiveHandle()");

        // Optional 객체에서 get()으로 value를 확보하면 값을 안 가지고, 있으면 못 뽑음 (익셉션 발생)
        // String sortValue = sort.isPresent() ? sort.get() : "DESC";
        Integer pageValue = page.orElse(1);

        /*
             String sortValue = sort.isPresent() ? sort.get() : "DESC";
             이거를 orElse 쓰는 방식으로 코드 리팩토링을 한다면?
         */

        String sortValue = sort.orElse("DESC");

        System.out.println("sortValue = " + sortValue);
        System.out.println("pageValue = " + pageValue);
    }

    /*
        @ModelAttribute :
        HTTP 요청에서 전달된 데이터를 자바 객체(Model Object)에 자동으로 매핑해주는 역할을 함

        ModelAttribute로 받을 때 할 수 있는 아주 효율적인 기능이 하나 더 있음.
     */
    @RequestMapping("/six")
    public void studySixHandle(@ModelAttribute TravelSchedule schedule) {

        System.out.println("StudyController.studySixHandle()");
        System.out.println(schedule.toString());
    }

     /*
        @PathVariable
      */                                      // /study/seven/123
     @RequestMapping("/seven/{subject}")   // seven 뒤에 데이터가 뭐가 있든 전부 작동함
     public void studySevenHandle(@PathVariable("subject") String subject) {
         System.out.println("StudyController.studySevenHandle()");
         System.out.println("subject = " + subject);

     }
}
