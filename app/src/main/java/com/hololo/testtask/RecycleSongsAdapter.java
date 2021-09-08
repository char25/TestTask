package com.hololo.testtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hololo.testtask.models.SongModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleSongsAdapter extends RecyclerView.Adapter<RecycleSongsAdapter.SongViewHolder> {

    public int ViewId;
    public int HoldersCount;
    public static int TotalHoldersCount;

    public ArrayList<SongModel> songModels;
    public Context mContext;

    public RecycleSongsAdapter(ArrayList<SongModel> songModels, int ViewId) {
        this.songModels = songModels;
        this.HoldersCount = songModels.size();
        this.ViewId = ViewId;

        TotalHoldersCount = 0;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(ViewId, parent, false);

        TotalHoldersCount++;

        return new SongViewHolder(view);
    }

    public int LastPos = 0;

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.UpdateViewHolder(songModels.get(position));

        if (LastPos < position) {
            holder.view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_left));
        }
        else {
            holder.view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_right));
        }

        LastPos = position;
    }

    @Override
    public int getItemCount() {
        return HoldersCount;
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        TextView SongNameTextView;
        TextView SongAuthorTextView;
        ShapeableImageView SongImage;
        View view;

        public SongViewHolder(@NonNull View view) {
            super(view);
            this.view = view;

            SongNameTextView = view.findViewById(R.id.SongNameTextView);
            SongAuthorTextView = view.findViewById(R.id.SongAuthorTextView);
            SongImage = view.findViewById(R.id.SongImage);
        }

        void UpdateViewHolder(SongModel songModel) {
            SongNameTextView.setText(songModel.SongName);
            SongAuthorTextView.setText(songModel.SongAuthor);
            SongImage.setImageResource(songModel.SongIcon);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.SetFragment(new FragmentPlayer(), mContext);
                }
            });
        }
    }
}