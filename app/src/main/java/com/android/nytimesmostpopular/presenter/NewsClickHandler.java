package com.android.nytimesmostpopular.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.android.nytimesmostpopular.model.News;
import com.android.nytimesmostpopular.view.NewDetailsActivity;

/**
 * Created by sharma4frnds on 26/07/19.
 */

public class NewsClickHandler {
    private final Context context;

    public NewsClickHandler(Context context) {
        this.context = context;
    }

    public void onSaveClick(View view, News news) {
        Intent nextInt = new Intent(view.getContext(), NewDetailsActivity.class);
        nextInt.putExtra("SELECTED_NEWS",news);
        context.startActivity(nextInt);
    }
}
