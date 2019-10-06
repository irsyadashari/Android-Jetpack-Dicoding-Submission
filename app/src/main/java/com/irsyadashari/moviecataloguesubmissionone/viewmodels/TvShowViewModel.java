package com.irsyadashari.moviecataloguesubmissionone.viewmodels;

import androidx.lifecycle.ViewModel;

import com.irsyadashari.moviecataloguesubmissionone.data.DataDummy;
import com.irsyadashari.moviecataloguesubmissionone.models.TvShow;

import java.util.List;

public class TvShowViewModel extends ViewModel {

    private TvShow mTvShow;

    public TvShow getTvShowModel(String tvShowId) {
        for (int i = 0; i < DataDummy.generateDummyMovies().size(); i++) {
            TvShow tvShowModel = DataDummy.generateDummyTvShow().get(i);
            if (tvShowModel.getTvShowId().equals(tvShowId)) {
                mTvShow = tvShowModel;
            }
        }
        return mTvShow;
    }

    public List<TvShow> getTvShow() {
        return DataDummy.generateDummyTvShow();
    }
}
