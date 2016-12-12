package me.ilich.upoedown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    private RecyclerView recyclerView;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        for (int i = 0; i < 100; i++) {
            users.add(new User(i, "User " + i));
        }
        Adapter adapter = new Adapter();
        adapter.setListener(new OnUserClick() {
            @Override
            public void onNameClick(String name) {
                Log.v("Sokolov", name);
            }

            @Override
            public void onAgeClick(int age) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(RecyclerViewActivity.this, Integer.toString(age), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    interface OnUserClick {
        void onNameClick(String name);

        void onAgeClick(int age);
    }

    private static class User {

        private final int age;
        private final String name;

        private User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView ageTextView;
        TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ageTextView = (TextView) itemView.findViewById(R.id.age);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
        }
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {

        private OnUserClick listener;

        public void setListener(OnUserClick click) {
            this.listener = click;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(View.inflate(RecyclerViewActivity.this, R.layout.layout_user, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final User user = users.get(position);
            holder.ageTextView.setText(Integer.toString(user.age));
            holder.ageTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onAgeClick(user.age);
                    }
                }
            });
            holder.nameTextView.setText(user.name);
            holder.nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onNameClick(user.name);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }

}
