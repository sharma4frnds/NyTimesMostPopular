package com.android.nytimesmostpopular.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.nytimesmostpopular.databinding.NewsDataBinding;
import com.android.nytimesmostpopular.model.News;
import com.android.nytimesmostpopular.presenter.NewsClickHandler;

import java.util.List;

/**
 * Created by sharma4frnds on 26/07/19.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final Context mContext;
    private final List<News> newsList;
    private LayoutInflater layoutInflater;

    public NewsAdapter(Context context, List<News> dataList) {
        this.mContext = context;
        this.newsList = dataList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        NewsDataBinding dataBinding = NewsDataBinding.inflate(layoutInflater, parent, false);
//        dataBinding.setImageUrl("https://static01.nyt.com/images/2019/07/26/opinion/26cohenWeb/26cohenWeb-thumbStandard.jpg");
//        dataBinding.setImageUrl(newsList.get(parent.getId()).getMedia().get(parent.getId()).getMediaMetadata().get(parent.getId()).getUrl());
        return new NewsViewHolder(dataBinding);

    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

        //SET VIEW DATA
        final News news = newsList.get(position);

        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private final NewsDataBinding newsDataBinding;

        NewsViewHolder(NewsDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.newsDataBinding = dataBinding;
            newsDataBinding.setHandler(new NewsClickHandler(mContext));
        }

        void bind(News news) {
            this.newsDataBinding.setNews(news);
            this.newsDataBinding.setImageUrl(news.getMedia().get(0).getMediaMetadata().get(0).getUrl());
        }
    }
}
