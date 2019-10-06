package com.irsyadashari.moviecataloguesubmissionone.viewmodels;

import androidx.lifecycle.ViewModel;

import com.irsyadashari.moviecataloguesubmissionone.data.DataDummy;
import com.irsyadashari.moviecataloguesubmissionone.models.Movie;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private Movie mMovie;

    public Movie getMovieModel(String movieId) {
        for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
            Movie movieModel = DataDummy.generateDummyMovies().get(i);
            if (movieModel.getMovieId().equals(movieId)) {
                mMovie = movieModel;
            }
        }
        return mMovie;
    }

    public List<Movie> getMovie() {
        return DataDummy.generateDummyMovies();
    }
}
