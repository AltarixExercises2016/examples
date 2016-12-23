package me.ilich.hellofragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_first)).setListener(new FirstFragment.OnClickButtonListener() {
            @Override
            public void onButtonClicked() {
                SecondFragment f = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment_2);
                f.setName("hello from activity");
            }
        });
        findViewById(R.id.second_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.container_fragment_2, SecondFragment.newInstance()).
                        addToBackStack("trz").
                        commit();
            }
        });
        findViewById(R.id.set_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment f = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_first);
                f.setName("Миша");
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().
                        popBackStack();
            }
        });
    }

    public void foo(String name) {
        FirstFragment f = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_first);
        f.setName(name);
    }
}
