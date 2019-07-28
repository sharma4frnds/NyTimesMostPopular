
package com.android.nytimesmostpopular.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import com.android.nytimesmostpopular.BR;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class News extends BaseObservable implements Serializable {


    @SerializedName("title")
    @Bindable
    private final String title;

    @SerializedName("byline")
    @Bindable
    private final String byline;

    @SerializedName("published_date")
    @Bindable
    private final String published_date;

    @SerializedName("media")
    @Bindable
    private List<Media> media = null;

    public News(String title, String byline, String published_date, List<Media> media) {
        this.title = title;
        this.byline = byline;
        this.published_date = published_date;
        this.media = media;

        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.byline);
        notifyPropertyChanged(BR.published_date);
    }

    protected News(Parcel in) {
        title = in.readString();
        byline = in.readString();
        published_date = in.readString();

    }

    public String getTitle() {
        return title;
    }

    public String getByline() {
        return byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public List<Media> getMedia() {
        return media;
    }

}
