package org.codenova.spring.controller.practice;

import org.codenova.spring.model.Body;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class BodyController {

    @RequestMapping("/calculate")
    public String calculateHandle(@ModelAttribute Body b, Model model) {
        /*
            ModelAttriubte 를 써서 객체로 파라미터를 바인딩하면,
            실제 파라미터는 해당 객체의 getter 를 통해 사용해야된다!

            ModelAttribute 로 받은 객체는 자동으로 addAttribute 처리가 된다.
            이름이 머로 attribute 가 되는가? 클래스명으로 (앞에만 소문자 처리되서)
         */
        double bmi = b.getWeight() / Math.pow(b.getHeight(), 2);
        model.addAttribute("bmi", bmi);
        model.addAttribute("body", b);

        return "body/calculate";
    }
}
