package com.example.restful.server;

import models.Movie;
import models.MovieStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/movies")
public class MovieHTML {
    @GetMapping
    public String showAlLMovies(Model model){
        Collection<Movie> movies = MovieStorage.movies.values();
        List<Movie> list = new ArrayList<>(movies);
        model.addAttribute("movies",list);
        return "allMovies";
    }
    @GetMapping("/new")
    public String makeMovie(){
        return "new_Movie";
    }

    @GetMapping("/{id}/edit")
    public String editMovie(
            @PathVariable("id") int id,
            Model model
    ){
        Movie movie = MovieStorage.movies.get(id);

        model.addAttribute("id",movie.id);
        model.addAttribute("name",movie.name);
        model.addAttribute("length",movie.length);

        return "edit_Movie";
    }
}
