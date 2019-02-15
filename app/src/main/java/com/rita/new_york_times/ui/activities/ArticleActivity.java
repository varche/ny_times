package com.rita.new_york_times.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.rita.new_york_times.R;
import com.rita.new_york_times.ui.recycler_adapters.RecyclerViewAdapter;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        TextView titleTextView = findViewById(R.id.article_title);
        TextView abstractTextView = findViewById(R.id.article_abstract);

        Intent intent = getIntent();
        String articleTitle = intent.getStringExtra(RecyclerViewAdapter.ARTICLE_TITLE);
        String articleAbstract = intent.getStringExtra(RecyclerViewAdapter.ARTICLE_ABSTRACT);

        titleTextView.setText(articleTitle);
        abstractTextView.setText(articleAbstract);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return true;
    }
}
