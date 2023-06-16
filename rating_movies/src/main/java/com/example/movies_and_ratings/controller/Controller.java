package com.example.movies_and_ratings.controller;

import com.example.movies_and_ratings.dto.GenreMoviesSubtotals;
import com.example.movies_and_ratings.dto.MovieRequest;
import com.example.movies_and_ratings.dto.MoviesOfLongestDurationResponse;
import com.example.movies_and_ratings.dto.ResponseOfTopRatedMovies;
import com.example.movies_and_ratings.service.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

   private final MoviesService moviesService;

    public Controller(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("api/v1/longest-duration-movies")
    public List<MoviesOfLongestDurationResponse> getLongestDurationMovies(){
       return moviesService.getLongestDurationMovies();
    }

    @PostMapping("api/v1/new-movie")
    public String saveMovie(@RequestBody final MovieRequest movieRequest){
        return moviesService.saveMovie(movieRequest);
    }

    @GetMapping("api/v1/top-rated-movies")
    public List<ResponseOfTopRatedMovies> getTopRatedMovies(){
        return moviesService.getTopRatedMovies();
    }

    @GetMapping("api/v1/genre-movies-with-subtotals")
    public List<GenreMoviesSubtotals> getGenreMoviesWithSubtotals(){
        return moviesService.getSubtotalsOfGenreMovies();
    }

    @PostMapping("api/v1/update-runtime-minutes")
    public String updateRuntime(){
        return moviesService.updateRuntimeMinutes();
    }

}

