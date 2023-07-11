package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    public ArrayList<CustomListPOJO>  arrayListListner;
    private List<CustomListPOJO> mListnerList;
    Context mContext;
    private Data data;
    public CustomListAdapter(List<CustomListPOJO> mListnerList, Context context){
        mContext =context;
        this.mListnerList = mListnerList;
        this.arrayListListner = new ArrayList<CustomListPOJO>();
        this.arrayListListner.addAll(mListnerList);
        this.data = new Data(context);
    }

    public static class viewHolder{
        ImageView mItemPic;
        TextView mGameName;
        TextView mPrice;
        Button mBtn;
    }

    @Override
    public int getCount() {
        return mListnerList.size();
    }

    @Override
    public Object getItem(int i) {
        return mListnerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final viewHolder holder;

        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.design_list,null);
            holder = new viewHolder();
            holder.mItemPic=(ImageView) view.findViewById(R.id.itemPic);
            holder.mGameName=(TextView) view.findViewById(R.id.gameName);
            holder.mPrice=(TextView)view.findViewById(R.id.PRICE);
            holder.mBtn=(Button) view.findViewById(R.id.btn);
            view.setTag(holder);
        }
        else {
            holder =(viewHolder) view.getTag();
        }
        try{
            int image = mListnerList.get(i).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mGameName.setText(mListnerList.get(i).getName());
            holder.mPrice.setText(mListnerList.get(i).getPrice());

//            holder.mGameName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(mContext, "You Clicked on "+holder.mGameName.getText(), Toast.LENGTH_SHORT).show();
//                }
//            });
            holder.mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    data.addItem(mListnerList.get(i).getName(),mListnerList.get(i).getPrice(),mListnerList.get(i).getImage());
                    Toast.makeText(mContext, "your item added in Cart", Toast.LENGTH_SHORT).show();
                }

            });
        }
        catch (Exception e) {

        }

            return view;
    }
}
