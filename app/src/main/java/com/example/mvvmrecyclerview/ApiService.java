package com.example.mvvmrecyclerview;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("demos/marvel/")
    Observable<ArrayList<HeroPojo>> getHeros();
}
