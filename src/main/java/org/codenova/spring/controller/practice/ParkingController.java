package org.codenova.spring.controller.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parking")
public class ParkingController {

    @RequestMapping("/form")
    public String formHandle() {

        return "parking/form";
    }

    @RequestMapping("/calculate")
    public String calculateHandle(@RequestParam("car") String car,
                                  @RequestParam("minutes") int minutes,
                                  @RequestParam("purchase") int purchase,
                                  Model model) {

        int chargeMinutes = minutes;
        if (purchase >= 100000) {
            chargeMinutes -= 5 * 60;
        } else if (purchase >= 50000) {
            chargeMinutes -= 4 * 60;
        } else if (purchase >= 30000) {
            chargeMinutes -= 3 * 60;
        } else {
            chargeMinutes -= 30;
        }

        int fee;
        if (chargeMinutes <= 0) {
            fee = 0;
        } else {
            fee = chargeMinutes / 10 * 1000;
        }

        // servlet 기반 MVC 돌릴때 req.setAttribute 와 같은 효과
        model.addAttribute("fee", fee);

        return "parking/calculate";
    }
}
