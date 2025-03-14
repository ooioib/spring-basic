package org.codenova.spring.controller.practice;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.codenova.spring.model.TableBooking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @RequestMapping("/form")
    public String bookingFormHandle() {
        return "booking/form";
    }

    /*
        자동으로 appAttribute 될 때 클래스명으로 등록 되는데 (앞글자만 소문자로 변경되서)
        @valid를 쓸 데는 그 다음 인자를 반드시 BindingResult로 설정해야됨.

     */

    @RequestMapping("/proceed")
    public String bookingProceedHandle(@ModelAttribute @Valid TableBooking booking,
                                       BindingResult result, Model model, HttpSession session) {

        System.out.println("booking proceed handle");
        System.out.println("booking: " + booking);
        System.out.println("error = " + result.hasErrors());

        String uuid = UUID.randomUUID().toString();
        model.addAttribute("uuid", uuid);
        model.addAttribute("booking", booking);
        if (!result.hasErrors()) {   // 유효성 검사 결과 error가 없다면
            return "booking/proceed";
        } else {
            // 어디 필드에서 에러가 난건지 확인하려면,
            // getFieldError(필드명) ==> 에러가 있으면 not null, 에러가 없으면 null
            FieldError customerNameError = result.getFieldError("customerName");
            System.out.println("customerNameError = " + customerNameError);
            model.addAttribute("customerNameError", result.getFieldError("customerName"));

            int guestsErrorCount = result.getFieldErrorCount("guests");
            System.out.println("guestsErrorCount = " + guestsErrorCount);
            model.addAttribute("guestsErrorCount", result.getFieldErrorCount("guests"));

            return "booking/proceed-error";
        }
    }
}
