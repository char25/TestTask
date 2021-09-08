package com.hololo.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static FragmentTransaction FragTrans;

    public static String TAG;
    public static ArrayList<SongModel> songModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = this.getClass().getName();
        songModels = new ArrayList<>();

        new Thread(TestAppend).start();

        SetFragment(new FragmentSongsList(), this);
    }

    public static void SetFragment(Fragment ObjFragment, Context context) {
        try {
            FragTrans = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
            FragTrans.replace(R.id.FragmentContainer, ObjFragment);
            FragTrans.commit();
        }
        catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    private Runnable TestAppend = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                songModels.add(new SongModel(R.mipmap.bilie_foreground, "Billie eilish", String.valueOf(i)));
            }
        }
    };
}