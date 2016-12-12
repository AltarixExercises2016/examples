package me.ilich.upoedown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.list);
        for (int i = 0; i < 100; i++) {
            users.add(new User(i, "User " + i));
        }
        listView.setAdapter(new Adapter());
    }

    private static class User {

        private final int age;
        private final String name;

        private User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    private class Adapter extends BaseAdapter {

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            final int r;
            if (position % 2 == 0) {
                r = 0;
            } else {
                r = 1;
            }
            return r;
        }

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public User getItem(int i) {
            return users.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                int viewType = getItemViewType(i);
                if (viewType == 0) {
                    view = View.inflate(ListViewActivity.this, R.layout.layout_user, null);
                    ViewHolder vh = new ViewHolder();
                    vh.ageTextView = (TextView) view.findViewById(R.id.age);
                    vh.nameTextView = (TextView) view.findViewById(R.id.name);
                    view.setTag(vh);
                }
                if (viewType == 1) {
                    view = View.inflate(ListViewActivity.this, android.R.layout.simple_list_item_2, null);
                    ViewHolder vh = new ViewHolder();
                    vh.ageTextView = (TextView) view.findViewById(android.R.id.text1);
                    vh.nameTextView = (TextView) view.findViewById(android.R.id.text2);
                    view.setTag(vh);
                }
            }
            ViewHolder vh = (ViewHolder) view.getTag();
            User user = getItem(i);
            vh.ageTextView.setText(Integer.toString(user.age));
            vh.nameTextView.setText(user.name);
            return view;
        }

        private class ViewHolder {
            TextView ageTextView;
            TextView nameTextView;
        }
    }

}
