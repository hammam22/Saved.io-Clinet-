package com.hammam.savedio;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("bookmarks") // specify the sub url for our base url
    public Call<List<MyBookmark>> getAllBookmarks(
            @Query("devkey") String devkey,
            @Query("key") String key
    );

    @DELETE("bookmarks")
    public Call<ResponseBody> deleteBookmark(
            @Query("devkey") String devkey,
            @Query("key") String key,
            @Query("id") String id
    );

    @POST("bookmarks")
    public Call<String> createBookmark(
            @Query("devkey") String devkey,
            @Query("key") String key,
            @Query("url") String url,
            @Query("title") String title
    );

}
