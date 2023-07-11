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

public class CustomListAdapter2 extends BaseAdapter {

    public ArrayList<CustomListPOJO>  arrayListListner2;
    private List<CustomListPOJO> mListnerList2;
    Context mContext2;
    private Data data;
    public CustomListAdapter2(List<CustomListPOJO> mListnerList2, Context context){
        mContext2 =context;
        this.mListnerList2 = mListnerList2;
        this.arrayListListner2 = new ArrayList<CustomListPOJO>();
        this.arrayListListner2.addAll(mListnerList2);
        this.data = new Data(context);
    }

    public static class viewHolder2{
        ImageView mItemPic;
        TextView mGameName;
        TextView mPrice;
    }

    @Override
    public int getCount() {
        return mListnerList2.size();
    }

    @Override
    public Object getItem(int i) {
        return mListnerList2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final viewHolder2 holder;

        if(view==null){
            view= LayoutInflater.from(mContext2).inflate(R.layout.design_list2,null);
            holder = new viewHolder2();
            holder.mItemPic=(ImageView) view.findViewById(R.id.itemPic);
            holder.mGameName=(TextView) view.findViewById(R.id.gameName);
            holder.mPrice=(TextView)view.findViewById(R.id.PRICE);

            view.setTag(holder);
        }
        else {
            holder =(viewHolder2) view.getTag();
        }
        try{
            int image = mListnerList2.get(i).getImage();
            holder.mItemPic.setImageResource(image);
            holder.mGameName.setText(mListnerList2.get(i).getName());
            holder.mPrice.setText(mListnerList2.get(i).getPrice());


        }
        catch (Exception e) {

        }

        return view;
    }
}
