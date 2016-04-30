package com.shafa.myretrofit.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shafa.myretrofit.R;
import com.shafa.myretrofit.controller.RestManager;
import com.shafa.myretrofit.model.helper.Constants;
import com.shafa.myretrofit.model.pojo.Flower;
import com.shafa.myretrofit.model.adapter.FlowerAdapter;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListner{
    private RecyclerView  mRecylerView;
    private RestManager mrestmanager;
    private FlowerAdapter mFlowerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        mrestmanager= new RestManager();
        Call<List<Flower>> listcall =  mrestmanager.getmFlowerService().getAllflower();
        listcall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {


                if (response.isSuccessful()){
                    List<Flower> flowerlist = response.body();
                    for (int i=0;i<flowerlist.size();i++)
                    {
                        Flower flower= flowerlist.get(i);
                        mFlowerAdapter.addFlower(flower);

                    }



                }else {
                    int sc= response.code();
                    switch (sc){

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });

    }

    private void configView() {
        mRecylerView=(RecyclerView)findViewById(R.id.mrecycle);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecylerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mFlowerAdapter= new FlowerAdapter(this);
        mRecylerView.setAdapter(mFlowerAdapter);


    }

    @Override
    public void Onclick(int positon) {
        Flower selectflower= mFlowerAdapter.getselectedflower(positon);
        Intent i = new Intent(MainActivity.this,DetailsActivity.class);
        i.putExtra(Constants.REFERENCE.FLOWER,selectflower);
        startActivity(i);

    }
}
