package org.codenova.spring.controller.practice;

import org.codenova.spring.model.Drama;
import org.codenova.spring.model.Movie;
import org.codenova.spring.repository.DramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/drama")
public class DramaController {

    @Autowired
    private DramaRepository dramaRepository;

    @RequestMapping("/form")
    public String formHandle() {
        return "drama/form";
    }

    @RequestMapping("/create-proceed")
    public String createProceedHandle(@ModelAttribute Drama drama) {
        boolean result = dramaRepository.create(drama);

        System.out.println("create = " + result);
        return "drama/create-proceed";
    }

    @RequestMapping("/list")
    public String listHandle(Model model) {
        List<Drama> dramas = dramaRepository.findAll();

        model.addAttribute("drama", dramas);
        return "drama/list";
    }

    @RequestMapping("/detail")
    public String detailHandle(@RequestParam("id") int id, Model model) {

        Drama one = dramaRepository.findById(id);
        if(one == null) {
            return "redirect:/drama/list";
        }

        model.addAttribute("found", one);
        return "drama/detail";
    }
}

