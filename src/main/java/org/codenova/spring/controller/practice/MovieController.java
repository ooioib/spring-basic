package org.codenova.spring.controller.practice;

import lombok.AllArgsConstructor;
import org.codenova.spring.model.Movie;
import org.codenova.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/form")
    public String formHandle() {
        return "movie/form";
    }

    @RequestMapping("/create-proceed")
    public String createProceedHandle(@ModelAttribute Movie movie) {
        boolean result = movieRepository.create(movie);

        System.out.println("create = " + result);
        return "movie/create-proceed";
    }

    @RequestMapping("/list")
    public String listHandle(Model model) {
        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("movies", movies);
        return "movie/list";
    }


    @RequestMapping("/detail")
    public String detailHandle(@RequestParam("id") int id, Model model) {

        Movie one = movieRepository.findById(id);
        if(one == null) {
            return "redirect:/movie/list";
        }

        model.addAttribute("found", one);
        return "movie/detail";
    }

}
