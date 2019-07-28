package com.android.nytimesmostpopular.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.nytimesmostpopular.R;
import com.android.nytimesmostpopular.api.ApiClient;
import com.android.nytimesmostpopular.api.ApiInterface;
import com.android.nytimesmostpopular.api.ApiResponse;
import com.android.nytimesmostpopular.model.News;
import com.android.nytimesmostpopular.utils.Constant;
import com.android.nytimesmostpopular.utils.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sharma4frnds on 26/07/19.
 */

public class MainActivity extends AppCompatActivity {

    private TextView noDataTv;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipe_refresh_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inits();
    }

    private void inits() {

        progressBar = findViewById(R.id.progressBar);
        noDataTv = findViewById(R.id.textViewNoData);
        recyclerView = findViewById(R.id.recycler_news);
        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (Util.isInternetConnected(MainActivity.this)) {
                    apiRequest("1");
                } else {
                    Toast.makeText(MainActivity.this, "No network connection. Please connect to internet ", Toast.LENGTH_LONG).show();
                }
            }
        });
        if (Util.isInternetConnected(MainActivity.this)) {
            apiRequest("1");
        } else {
            Toast.makeText(MainActivity.this, "No network connection. Please connect to internet ", Toast.LENGTH_LONG).show();
        }
    }

    private void apiRequest(String period) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.getNewsData(period, Constant.API_KEY);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                int statusCode = response.code();
                if (null != swipe_refresh_layout)
                    swipe_refresh_layout.setRefreshing(false);
                if (statusCode == 200) {
                    List<News> newsList = response.body().getResults();
                    setupRecycler(newsList);
                } else {
                    showError("Server Problem. Try again!");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                if (null != swipe_refresh_layout)
                    swipe_refresh_layout.setRefreshing(false);
                showError(t.getMessage());
            }
        });
    }

    private void setupRecycler(List<News> dataList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new NewsAdapter(this, dataList));

        assert dataList != null;
        if (dataList.size() > 0) {
            dataVisible();
        } else {
            showError("No News..!");
        }
    }

    private void showError(String message) {
        noDataTv.setText(message);

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        noDataTv.setVisibility(View.VISIBLE);
    }

    private void dataVisible() {
        noDataTv.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

}
