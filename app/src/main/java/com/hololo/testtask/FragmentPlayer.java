package com.hololo.testtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        Init(view);
        RightAppBarIcon.setVisibility(View.GONE);

        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left));

        LeftButtonClick(R.mipmap.arrow, "Hello", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.SetFragment(new FragmentSongsList(), getContext());
            }
        }, view);

        return view;
    }
}