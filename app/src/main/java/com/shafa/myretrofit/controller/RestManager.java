package com.shafa.myretrofit.controller;

import com.shafa.myretrofit.model.callback.FlowerService;
import com.shafa.myretrofit.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shafque Sattar on 13-04-2016  MyRetrofit
 */
public class RestManager {
    private FlowerService mFlowerService;

    public FlowerService getmFlowerService() {
        if (mFlowerService==null){
            Retrofit mretrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mFlowerService=mretrofit.create(FlowerService.class);
        }




        return mFlowerService;
    }
}
