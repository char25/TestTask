package com.hololo.testtask;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class FragmentPlayer extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player, container, false);

        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
        view.startAnimation(anim);

        LeftButtonClick(R.drawable.arr, "Hello", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.SetFragment(new FragmentSongsList(), getContext());
            }
        }, view);

        return view;
    }
}