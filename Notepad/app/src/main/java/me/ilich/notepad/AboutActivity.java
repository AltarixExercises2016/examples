package me.ilich.notepad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static me.ilich.notepad.R.id.version;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Button githubButton = (Button) findViewById(R.id.github);
        githubButton.setOnClickListener(this);
        TextView versionTextView = (TextView) findViewById(version);
        String versionPattern = getString(R.string.version);
        String version = String.format(versionPattern, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE);
        versionTextView.setText(version);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.github:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/AltarixExercises2016/examples"));
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final boolean b;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                b = true;
                break;
            default:
                b = super.onOptionsItemSelected(item);
                break;
        }
        return b;
    }

}