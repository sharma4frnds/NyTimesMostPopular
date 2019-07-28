package com.android.nytimesmostpopular.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sharma4frnds on 26/07/19.
 */


public interface ApiInterface {

    @GET("mostpopular/v2/viewed/{period}.json")
    Call<ApiResponse> getNewsData(@Path("period") String period,
                                     @Query("api-key") String apiKey);
}
