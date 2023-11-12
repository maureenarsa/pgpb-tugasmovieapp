package com.example.tugas_retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;

import com.example.tugas_retrofitapp.databinding.ActivityMainBinding;
import com.example.tugas_retrofitapp.model.Movie;
import com.example.tugas_retrofitapp.model.MovieResponse;
import com.example.tugas_retrofitapp.network.ApiClient;
import com.example.tugas_retrofitapp.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "56b4934e2a02e980f7a7b57733bff2d3";
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setSupportActionBar(binding.toolbar);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tampilData();

    }


    private void tampilData() {
        final RecyclerView recyclerView = binding.rvMovie;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() != null) {
                    final List<Movie> movies = response.body().getResults();
                    Log.d("Jumlah Film", "Number of movies received: " + movies.size());
                    Toast.makeText(MainActivity.this, "Jumlah Film: " + movies.size(), Toast.LENGTH_LONG).show();
                    recyclerView.setAdapter(new MovieAdapter(movies, getApplicationContext()));
                } else {
                    Log.e("Response Error", "Tidak ada respons dari API");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

                Log.e("Gagal", t.toString());
                Toast.makeText(MainActivity.this, "Cek koneksi internet!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
