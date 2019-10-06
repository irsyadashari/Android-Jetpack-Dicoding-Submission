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
import com.irsyadashari.moviecataloguesubmissionone.models.TvShow;

import java.util.ArrayList;
import java.util.List;

public class RVTvShowAdapter extends RecyclerView.Adapter<RVTvShowAdapter.TvShowViewHolder> {

    private final Activity activity;
    private List<TvShow> tvShowModels = new ArrayList<>();

    public RVTvShowAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<TvShow> getTvShowModels() {
        return tvShowModels;
    }

    public void setListTvShow(List<TvShow> listTvShow) {
        if (listTvShow == null) return;
        this.tvShowModels.clear();
        this.tvShowModels.addAll(listTvShow);
    }

    @NonNull
    @Override
    public RVTvShowAdapter.TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVTvShowAdapter.TvShowViewHolder holder, int position) {
        holder.textViewTitle.setText(getTvShowModels().get(position).getTitle());
        holder.textViewDesc.setText(getTvShowModels().get(position).getDescription());
        holder.textViewDate.setText(getTvShowModels().get(position).getRelease());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_TvSHOW, getTvShowModels().get(position).getTvShowId());
            activity.startActivity(intent);
        });
        Glide.with(holder.itemView.getContext())
                .load(activity.getApplicationContext().getResources().getIdentifier(getTvShowModels().get(position).getImagePath(), "drawable", activity.getApplicationContext().getPackageName()))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_image)
                        .error(R.drawable.ic_error))
                .into(holder.imageViewPoster);

    }

    @Override
    public int getItemCount() {
        return getTvShowModels().size();
    }

    class TvShowViewHolder extends RecyclerView.ViewHolder {

        final TextView textViewTitle;
        final TextView textViewDesc;
        final TextView textViewDate;
        final ImageView imageViewPoster;

        TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.movie_name);
            textViewDesc = itemView.findViewById(R.id.movie_desc);
            textViewDate = itemView.findViewById(R.id.movie_date);
            imageViewPoster = itemView.findViewById(R.id.movie_poster_image);
        }
    }
}
