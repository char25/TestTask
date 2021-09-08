package com.hololo.testtask;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;

public class FragmentSongsList extends BaseFragment {

    private RecyclerView recyclerView;
    private RecycleSongsAdapter RecycleSongsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_songs_list, container, false);
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_right));

        recyclerView = view.findViewById(R.id.SongsRecycleView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        RecycleSongsAdapter = new RecycleSongsAdapter(MainActivity.songModels, R.layout.lst_view);
        recyclerView.setAdapter(RecycleSongsAdapter);

        Init(view);

        return view;
    }
}