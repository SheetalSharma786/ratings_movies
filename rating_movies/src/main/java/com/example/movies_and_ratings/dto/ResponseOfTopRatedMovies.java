package com.example.movies_and_ratings.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOfTopRatedMovies {
    private String tconst;
    private String primaryTitle;
    private String genres;
    private BigDecimal averageRating;
}
