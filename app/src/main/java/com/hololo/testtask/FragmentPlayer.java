package com.hololo.testtask;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hololo.testtask.models.SongModel;


public class FragmentPlayer extends BaseFragment {

    private RecyclerView recyclerView;
    private RecycleSongsAdapter recycleSongsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player, container, false);
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_left));

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        recyclerView = view.findViewById(R.id.SongsRecycleView);
        recyclerView.setLayoutManager(manager);

        recycleSongsAdapter = new RecycleSongsAdapter(MainActivity.songModels, R.layout.player_view);
        recyclerView.setAdapter(recycleSongsAdapter);
        recyclerView.setItemViewCacheSize(0);
        DisableScrollingRecycleView(recyclerView);

        Init(view);

        LeftButtonClick(R.mipmap.arrow, "this song", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.SetFragment(new FragmentSongsList(), getContext());
            }
        });

        ImageView NextSound = view.findViewById(R.id.NextSound);
        NextSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CurrentPos >= 0 && CurrentPos != MainActivity.songModels.size()) {
                    CurrentPos++;
                }

                manager.scrollToPosition(CurrentPos);
            }
        });

        ImageView PreviewSound = view.findViewById(R.id.PreviewSound);
        PreviewSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CurrentPos <= MainActivity.songModels.size() && CurrentPos != 0) {
                    CurrentPos--;
                }

                manager.scrollToPosition(CurrentPos);
                manager.setReverseLayout(true);
            }
        });

        return view;
    }

    private void DisableScrollingRecycleView(RecyclerView recyclerView) {
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // Stop only scrolling.
                return rv.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING;
            }
        });
    }

    static int CurrentPos = 0;
}