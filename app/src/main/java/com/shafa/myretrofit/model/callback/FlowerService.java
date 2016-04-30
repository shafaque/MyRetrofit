package com.shafa.myretrofit.model.callback;

import com.shafa.myretrofit.model.pojo.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Shafque Sattar on 13-04-2016  MyRetrofit
 */
public interface FlowerService {
    @GET("/feeds/flowers.json")
    Call<List<Flower>>getAllflower();
}