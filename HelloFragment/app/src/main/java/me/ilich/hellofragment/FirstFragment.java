package me.ilich.hellofragment;

import android.database.sqlite.SQLiteDatabase;
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

public class FirstFragment extends Fragment {

    private TextView nameTextView;
    private OnClickButtonListener listener = null;

    public static FirstFragment newInstance(String a) {
        Bundle args = new Bundle();
        args.putString("aaaa", a);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        getArguments().getString("aaaaa");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView = (TextView) view.findViewById(R.id.name);
        nameTextView.setText("Вася");
        view.findViewById(R.id.call_listener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onButtonClicked();
                }
            }
        });
    }

    public void setName(String name) {
        nameTextView.setText(name);
    }

    public void setListener(OnClickButtonListener listener) {
        this.listener = listener;
    }

    public interface OnClickButtonListener {
        void onButtonClicked();
    }

}
