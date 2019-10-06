package com.irsyadashari.moviecataloguesubmissionone.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.irsyadashari.moviecataloguesubmissionone.R;
import com.irsyadashari.moviecataloguesubmissionone.UI.DetailMovieActivity;
import com.irsyadashari.moviecataloguesubmissionone.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class RVMovieAdapter extends RecyclerView.Adapter<RVMovieAdapter.MovieViewHolder> {

    private final Activity activity;
    private List<Movie> movieModels = new ArrayList<>();

    public RVMovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<Movie> getMovieModels() {
        return movieModels;
    }

    public void setListMovie(List<Movie> list) {
        if (list == null) return;
        this.movieModels.clear();
        this.movieModels.addAll(list);
    }

    @NonNull
    @Override
    public RVMovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVMovieAdapter.MovieViewHolder holder, int position) {
        holder.textViewTitle.setText(getMovieModels().get(position).getTitle());
        holder.textViewDesc.setText(getMovieModels().get(position).getDescription());
        holder.textViewDate.setText(getMovieModels().get(position).getRelease());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getMovieModels().get(position).getMovieId());
            activity.startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(activity.getApplicationContext().getResources().getIdentifier(getMovieModels().get(position).getImagePath(), "drawable", activity.getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster);

    }

    @Override
    public int getItemCount() {
        return getMovieModels().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        MovieViewHolder(@NonNull View item) {
            super(item);
            textViewTitle = item.findViewById(R.id.movie_name);
            textViewDesc = item.findViewById(R.id.movie_desc);
            textViewDate = item.findViewById(R.id.movie_date);
            imageViewPoster = item.findViewById(R.id.movie_poster_image);
        }
    }
}
