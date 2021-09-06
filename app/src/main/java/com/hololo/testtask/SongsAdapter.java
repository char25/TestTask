package com.hololo.testtask;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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



        return convertView;
    }
}
