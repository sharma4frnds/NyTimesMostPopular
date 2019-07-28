package com.android.nytimesmostpopular.api;


import com.android.nytimesmostpopular.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sharma4frnds on 26/07/19.
 */


public class ApiClient {
    private static Retrofit retrofit = null;

    private ApiClient() {

    }
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
