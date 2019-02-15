package com.example.mvvmrecyclerview;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://simplifiedcoding.net/";

    private static Retrofit getRetrofitInstance()
    {
       // Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ApiService getApiService()
    {
        return getRetrofitInstance().create(ApiService.class);
    }
}
