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
    }

    public void LeftButtonClick(int IconId, String Text, View.OnClickListener onClickListener, View view) {

        LeftAppBarIcon.setImageDrawable(getResources().getDrawable(IconId));
        AppBarText.setText(Text);

        LeftAppBarIcon.setOnClickListener(onClickListener);
    }
}
