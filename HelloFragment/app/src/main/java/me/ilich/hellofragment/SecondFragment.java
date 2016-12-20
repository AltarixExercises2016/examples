package me.ilich.hellofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ilich on 16.12.16.
 */

public class SecondFragment extends Fragment {

    private TextView nameTextView;

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView = (TextView) view.findViewById(R.id.name);
        nameTextView.setText("Иван");
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).foo("hello from f2");
            }
        });
    }

    public void setName(String name) {
        nameTextView.setText(name);
    }

}
