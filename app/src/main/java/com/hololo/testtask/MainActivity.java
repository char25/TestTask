package com.hololo.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    static FragmentTransaction FragTrans;
    public static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = this.getClass().getName();

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
}