package com.example.tugas_retrofitapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> results;

    @SerializedName("total_pages")
    private int totalPages;

    public List<Movie> getResults() {
        return results;
    }

}
