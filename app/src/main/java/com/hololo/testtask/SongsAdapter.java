package com.hololo.testtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<SongModel>{

    private Context mContext;
    private int mResource;

    public SongsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SongModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);
        final View view = convertView;

        SongModel SongModel = getItem(position);

        TextView SongAuthorTextView = view.findViewById(R.id.SongAuthorTextView);
        TextView SongNameTextView = view.findViewById(R.id.SongNameTextView);

        SongAuthorTextView.setText(SongModel.SongAuthor);
        SongNameTextView.setText(SongModel.SongName);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.SetFragment(new FragmentPlayer(SongModel), mContext);
            }
        });

        convertView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_right));

        return convertView;
    }
}
