package com.hololo.testtask;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public ImageView RightAppBarIcon;
    public ImageView LeftAppBarIcon;
    public TextView AppBarText;

    public void Init(View view) {
        RightAppBarIcon = view.findViewById(R.id.RightAppBarIcon);
        LeftAppBarIcon = view.findViewById(R.id.LeftAppBarIcon);
        AppBarText = view.findViewById(R.id.AppBarText);
        AppBarText.setPadding(60, 0,0,0);
        LeftAppBarIcon.setVisibility(View.GONE);
    }

    public void LeftButtonClick(int IconId, String Text, View.OnClickListener onClickListener) {
        RightAppBarIcon.setVisibility(View.GONE);
        LeftAppBarIcon.setVisibility(View.VISIBLE);
        LeftAppBarIcon.setImageDrawable(getResources().getDrawable(IconId));
        AppBarText.setText(Text);
        AppBarText.setPadding(0, 0,0,0);
        LeftAppBarIcon.setOnClickListener(onClickListener);
    }
}
