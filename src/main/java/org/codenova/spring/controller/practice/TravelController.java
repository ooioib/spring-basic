package org.codenova.spring.controller.practice;

import org.codenova.spring.model.TravelSchedule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/travel")
public class TravelController {

    @RequestMapping("/form")
    public String travelFormHandle() {
        return "travel/form";
    }

    @RequestMapping("/result")
    public String travelResultHandle(@ModelAttribute TravelSchedule schedule, Model model) {

        try {
            int tempTotal = schedule.getStayCost() + schedule.getTrafficCost() + schedule.getFoodCost() + schedule.getOtherCost();
            int additionalTotal = 0;

            if (schedule.getDestination().equals("international")) {
                additionalTotal = (int) (tempTotal * 0.1);
            }

            int costPerPerson = (tempTotal + additionalTotal) / schedule.getPersons();

            model.addAttribute("stayCost", schedule.getStayCost());
            model.addAttribute("trafficCost", schedule.getTrafficCost());
            model.addAttribute("foodCost", schedule.getFoodCost());
            model.addAttribute("otherCost", schedule.getOtherCost());
            model.addAttribute("tempTotal", tempTotal);
            model.addAttribute("additionalTotal", additionalTotal);
            model.addAttribute("costPerPerson", costPerPerson);

            return "travel/result";

        } catch (Exception e) {
            return "redirect:/travel/form";
        }
    }
}
