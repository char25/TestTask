package com.hololo.testtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ListView SongsListView;
    private ListAdapter CustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongsListView = findViewById(R.id.SongsListView);

        ArrayList<SongModel> songModels = new ArrayList<>();
        songModels.add(new SongModel(R.mipmap.bilie, "Test", ""));
        songModels.add(new SongModel(R.mipmap.bilie, "Test 1", ""));

        CustomAdapter = new SongsAdapter(this, R.layout.lst_view, songModels);
        SongsListView.setAdapter(CustomAdapter);
    }
}