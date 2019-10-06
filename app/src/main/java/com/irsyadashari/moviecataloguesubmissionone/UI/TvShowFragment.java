package com.irsyadashari.moviecataloguesubmissionone.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irsyadashari.moviecataloguesubmissionone.R;
import com.irsyadashari.moviecataloguesubmissionone.adapters.RVTvShowAdapter;
import com.irsyadashari.moviecataloguesubmissionone.models.TvShow;
import com.irsyadashari.moviecataloguesubmissionone.viewmodels.TvShowViewModel;

import java.util.List;
//TODO:IMPORT KALO MAU DEBUG import com.irsyadashari.moviecataloguesubmissionone.debug.R;


public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TvShowFragment() {
        // Required empty public constructor
    }

    static Fragment newInstance() {
        return new TvShowFragment();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TvShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TvShowFragment newInstance(String param1, String param2) {
        TvShowFragment fragment = new TvShowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tvShow);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            TvShowViewModel tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
            List<TvShow> tvShowModels = tvShowViewModel.getTvShow();

            RVTvShowAdapter tvShowAdapter = new RVTvShowAdapter(getActivity());
            tvShowAdapter.setListTvShow(tvShowModels);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(tvShowAdapter);
        }
    }
}
