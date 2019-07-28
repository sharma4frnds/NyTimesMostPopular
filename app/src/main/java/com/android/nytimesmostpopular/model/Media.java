
package com.android.nytimesmostpopular.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Media extends BaseObservable implements Serializable {

    @SerializedName("media-metadata")
    @Bindable
    private List<MediaMetadata> mediaMetadata = null;

    public Media(List<MediaMetadata> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

}
