package com.hololo.testtask;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public void LeftButtonClick(int IconId, String Text, View.OnClickListener onClickListener, View view) {
        ImageView LeftAppBarIcon = view.findViewById(R.id.LeftAppBarIcon);
        TextView AppBarText = view.findViewById(R.id.AppBarText);

        LeftAppBarIcon.setImageDrawable(getResources().getDrawable(IconId));
        AppBarText.setText(Text);

        LeftAppBarIcon.setOnClickListener(onClickListener);
    }
}
