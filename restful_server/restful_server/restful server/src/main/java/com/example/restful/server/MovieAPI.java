package com.example.restful.server;

import com.google.gson.Gson;
import models.Movie;
import models.MovieStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/movies")
public class MovieAPI {
    //create
    @PostMapping("/new")
    public ModelAndView createMovie(
            @RequestParam("name") String name,
            @RequestParam("length") int length
    ){
        Movie movie = new Movie(name,length);
        MovieStorage.movies.put(movie.id,movie);
        return new ModelAndView("redirect:/movies");
    }

    //get all movies
    @GetMapping("/get")
    @ResponseBody
    public List<Movie> getAllMovies(){
        Collection<Movie> movies = MovieStorage.movies.values();
        return new ArrayList<>(movies);
    }

    //get a movie

    @GetMapping("/{id}")
    @ResponseBody
    public Movie updateMountain(
            @PathVariable("id") int id,
            @RequestBody String body
    ){
        return MovieStorage.movies.get(id);
    }

    //Update an existing movie

    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    @ResponseBody
    public Movie updateMovie(
            @PathVariable("id") int id,
            @RequestBody String body
    ){
        Gson gson = new Gson();
        Movie newMovie = gson.fromJson(body,Movie.class);

        Movie movie = MovieStorage.movies.get(id);
        movie.name = newMovie.name;
        movie.length = newMovie.length;
        return movie;
    }

    //Delete an existing movie

    @DeleteMapping("/{id}")
    @ResponseBody
    public Movie deleteMovie(@PathVariable("id") int id){
        Movie movie = MovieStorage.movies.get(id);
        MovieStorage.movies.remove(id);
        return movie;
    }
}
