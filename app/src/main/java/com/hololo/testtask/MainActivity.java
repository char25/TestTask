package com.hololo.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.hololo.testtask.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private FragmentTransaction FragTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragTrans = getSupportFragmentManager().beginTransaction();
        SetFragment(R.id.FragmentContainer, new FragmentSongsList());
    }

    private void SetFragment(int id, Fragment ObjFragment) {
        FragTrans.replace(id, ObjFragment);
        FragTrans.commit();
    }
}