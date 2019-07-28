
package com.android.nytimesmostpopular.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import java.io.Serializable;

import com.android.nytimesmostpopular.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class MediaMetadata extends BaseObservable implements Serializable {

    @SerializedName("url")
    @Bindable
    private String url;

    @SerializedName("format")
    @Bindable
    private String format;

    @SerializedName("height")
    @Bindable
    private Integer height;

    @SerializedName("width")
    @Bindable
    private Integer width;

    public MediaMetadata(String url, String format, Integer height, Integer width) {
        this.url = url;
        this.format = format;
        this.height = height;
        this.width = width;
        notifyPropertyChanged(BR.url);
    }

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())
                .into(view);
    }

}
