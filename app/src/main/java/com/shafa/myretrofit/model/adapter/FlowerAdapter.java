package com.shafa.myretrofit.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shafa.myretrofit.R;
import com.shafa.myretrofit.model.pojo.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shafaque Sattar on 13-04-2016
 */
public class FlowerAdapter  extends RecyclerView.Adapter<FlowerAdapter.Holder>{
    private List<Flower> mFlower;
    private FlowerClickListner mlistner;

    public FlowerAdapter(FlowerClickListner listner) {
        mFlower= new ArrayList<>();
         mlistner = listner;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row_vew= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);
        return new Holder(row_vew);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower currFlower = mFlower.get(position);

        holder.mflowername.setText(currFlower.getName());
        holder.mflowerprice.setText(String.format("$%.2f", currFlower.getPrice()));

        Picasso.with(holder.itemView.getContext())
                .load("http://services.hanselandpetal.com/photos/" + currFlower.getPhoto())
                .into(holder.mphoto);



    }

    @Override
    public int getItemCount() {
        return mFlower.size();
    }

    public  void addFlower(Flower flower) {
        mFlower.add(flower);
        notifyDataSetChanged();


    }

    public Flower getselectedflower(int positon) {
       return mFlower.get(positon);

    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mphoto;
        private TextView mflowername;
        private TextView mflowerprice;

        public Holder(View itemView) {

            super(itemView);
            mphoto=(ImageView)itemView.findViewById(R.id.mphoto);
            mflowername=(TextView)itemView.findViewById(R.id.flowername);
            mflowerprice=(TextView)itemView.findViewById(R.id.flowerprice);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mlistner.Onclick(getLayoutPosition());

        }
    }
    public interface  FlowerClickListner{
       void Onclick (int positon);
    }
}
