package com.hololo.testtask;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;

public class FragmentSongsList extends Fragment {

    private ListView SongsListView;
    private ListAdapter CustomAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_songs_list, container, false);
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left));

        SongsListView = view.findViewById(R.id.SongsListView);

        ArrayList<SongModel> songModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            songModels.add(new SongModel(R.mipmap.bilie, "Test", ""));
        }


        CustomAdapter = new SongsAdapter(getContext(), R.layout.lst_view, songModels);
        SongsListView.setAdapter(CustomAdapter);

        return view;
    }
}