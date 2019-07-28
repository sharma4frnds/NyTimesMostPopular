package com.android.nytimesmostpopular.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.nytimesmostpopular.R;
import com.android.nytimesmostpopular.databinding.ActivityDetailsBinding;
import com.android.nytimesmostpopular.model.News;


/**
 * Created by sharma4frnds on 26/07/19.
 */


public class NewDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        News news = (News) getIntent().getSerializableExtra("SELECTED_NEWS");

        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setNews(news);
        if (news.getMedia().get(0).getMediaMetadata() != null && news.getMedia().get(0).getMediaMetadata().size() > 1)
            binding.setImageUrl(news.getMedia().get(0).getMediaMetadata().get(2).getUrl());
        else
            binding.setImageUrl(news.getMedia().get(0).getMediaMetadata().get(0).getUrl());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
