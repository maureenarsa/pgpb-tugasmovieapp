package com.example.tugas_retrofitapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath;


    public Movie(String posterPath, String overview,Integer id,
                String title, String backdropPath) {
        this.posterPath = posterPath;
        this.overview = overview;
        this.id = id;
        this.title = title;
        this.backdropPath = backdropPath;

    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }
    public String getBackdropPath() {
        return backdropPath;
    }

}
