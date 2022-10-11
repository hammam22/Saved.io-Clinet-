package com.hammam.savedio;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static ApiInterface getClient() {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://devapi.saved.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;
    }

}
