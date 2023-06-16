package com.example.movies_and_ratings.service;


import com.example.movies_and_ratings.dto.GenreMoviesSubtotals;
import com.example.movies_and_ratings.dto.MovieRequest;
import com.example.movies_and_ratings.dto.MoviesOfLongestDurationResponse;
import com.example.movies_and_ratings.dto.ResponseOfTopRatedMovies;

import com.example.movies_and_ratings.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }


    public List<MoviesOfLongestDurationResponse> getLongestDurationMovies(){
        List<Tuple> longestDurationMovies = moviesRepository.getLongestDurationMovies();

        List<MoviesOfLongestDurationResponse> responses = new ArrayList<>();


        for (Tuple tuple : longestDurationMovies) {
            String tconst = (String) tuple.get("tconst");
            String primaryTitle = (String) tuple.get("primaryTitle");
            Integer runtimeMinutes = (Integer) tuple.get("runtimeMinutes");
            String genres = (String) tuple.get("genres");

            MoviesOfLongestDurationResponse response = new MoviesOfLongestDurationResponse(tconst, primaryTitle,runtimeMinutes, genres);
            responses.add(response);
        }

        return responses;


    }

    public String saveMovie(final MovieRequest movieRequest){
        String tconst = movieRequest.getTconst();
        String primaryTitle = movieRequest.getPrimaryTitle();
        String titleType = movieRequest.getTitleType();
        Integer runtimeMinutes = movieRequest.getRuntimeMinutes();
        String genres = movieRequest.getGenres();
        moviesRepository.saveMovie(tconst,primaryTitle,titleType,runtimeMinutes,genres);
      return "success";
    }

    public List<ResponseOfTopRatedMovies> getTopRatedMovies(){
        List<Tuple> tuples = moviesRepository.getTopRatedMovies();
        List<ResponseOfTopRatedMovies> responses = new ArrayList<>();

        for (Tuple tuple : tuples) {
            String tconst = (String) tuple.get("tconst");
            String primaryTitle = (String) tuple.get("primaryTitle");
            String genres = (String) tuple.get("genres");
            BigDecimal averageRating = (BigDecimal) tuple.get("averageRating");

            ResponseOfTopRatedMovies response = new ResponseOfTopRatedMovies(tconst, primaryTitle, genres, averageRating);
            responses.add(response);
        }

        return responses;
    }
    public List<GenreMoviesSubtotals> getSubtotalsOfGenreMovies(){
        List<Tuple> genreMoviesWithSubtotals = moviesRepository.getGenreMoviesWithSubtotals();
        List<GenreMoviesSubtotals> responses = new ArrayList<>();

        for (Tuple tuple : genreMoviesWithSubtotals) {
            String primaryTitle = (String) tuple.get("primaryTitle");
            String genres = (String) tuple.get("genres");
            BigDecimal numVotes = (BigDecimal) tuple.get("numVotes");

           GenreMoviesSubtotals genreMoviesSubtotals =  new GenreMoviesSubtotals(genres,primaryTitle,numVotes);
            responses.add(genreMoviesSubtotals);
        }

        return responses;
    }

    public String updateRuntimeMinutes(){
        moviesRepository.updateRuntimeMinutes();
        return "updated";
    }
}
