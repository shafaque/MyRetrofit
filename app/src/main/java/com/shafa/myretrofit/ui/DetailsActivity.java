package com.shafa.myretrofit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.shafa.myretrofit.R;
import com.shafa.myretrofit.model.helper.Constants;
import com.shafa.myretrofit.model.pojo.Flower;
import com.squareup.picasso.Picasso;

/**
 * Created by Shafque Sattar on 14-04-2016  MyRetrofit
 */
public class DetailsActivity extends AppCompatActivity {
    private ImageView mPhoto;
    private TextView mName, mId, mCategory, mInstruction, mPrice;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent= getIntent();
        Flower flower= (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);
        ConfigView();

        mId.setText(String.format("%d", flower.getProductId()));
        mName.setText(flower.getName());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstructions());
        mPrice.setText(String.format("$%.2f", flower.getPrice()));

        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/" + flower.getPhoto()).into(mPhoto);

    }





    private void ConfigView() {
        mPhoto = (ImageView) findViewById(R.id.flowerPhoto);
        mName = (TextView) findViewById(R.id.flowerName);
        mId = (TextView) findViewById(R.id.flowerId);
        mCategory = (TextView) findViewById(R.id.flowerCategory);
        mInstruction = (TextView) findViewById(R.id.flowerInstruction);
        mPrice = (TextView) findViewById(R.id.flowerPrice);

    }
}
