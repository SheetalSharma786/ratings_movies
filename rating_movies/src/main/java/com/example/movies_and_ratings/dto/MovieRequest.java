package com.example.movies_and_ratings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {
    private String tconst;
    private String titleType;
    private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;
}
