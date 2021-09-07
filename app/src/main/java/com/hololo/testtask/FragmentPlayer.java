package com.hololo.testtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hololo.testtask.models.SongModel;


public class FragmentPlayer extends BaseFragment {

    public SongModel SongModel;

    public FragmentPlayer(SongModel songModel) {
        this.SongModel = songModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player, container, false);
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left));

        ShapeableImageView SongImage = view.findViewById(R.id.SongImage);
        SongImage.setImageResource(R.mipmap.bilie_foreground);

        TextView SongNameTextView = view.findViewById(R.id.SongNameTextView);
        TextView SongAuthorTextView = view.findViewById(R.id.SongAuthorTextView);

        SongNameTextView.setText(SongModel.SongName);
        SongAuthorTextView.setText("Unknown " + SongModel.SongAuthor);

        Init(view);

        LeftButtonClick(R.mipmap.arrow, "this song", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.SetFragment(new FragmentSongsList(), getContext());
            }
        });

        return view;
    }
}