package com.example.tugas_retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugas_retrofitapp.databinding.ItemMovieBinding;
import com.example.tugas_retrofitapp.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemMovieViewHolder> {
    private Context context;
    private List<com.example.tugas_retrofitapp.model.Movie> movieList;
    private int rowLayout;
    public MovieAdapter(List<Movie> list,Context context) {
        movieList = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding =
                ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()),parent,
                        false);
        return new ItemMovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMovieViewHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ItemMovieViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding binding;
        public ItemMovieViewHolder(ItemMovieBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(com.example.tugas_retrofitapp.model.Movie data){
            binding.title.setText(data.getTitle());

            binding.description.setText(data.getOverview());
            Log.d("Photo", "bind: " + data.getBackdropPath());
            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + data.getPosterPath())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.backbg);
        }
        }

    }


