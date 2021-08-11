package com.gurjeet.tourismapplication;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {

    private ArrayList<CountryLocation> countries;
    private LayoutInflater inflater;//we need this to link with the row_list.xml


    //constructor
    public CountryAdapter(Context context, ArrayList<CountryLocation> countries) {
        this.countries = countries;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //here we are creating the view
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.list_row,null); //here we linked listview of this class
            holder=new ViewHolder();
            holder.name=convertView.findViewById(R.id.txvLocationname);
            holder.price=convertView.findViewById(R.id.txvPrice);
            holder.img=convertView.findViewById(R.id.imvLocationImg);

            convertView.setTag(holder);
        }else
            holder=(ViewHolder)convertView.getTag();

        holder.name.setText(countries.get(position).getLocationName());
        holder.price.setText(String.valueOf(countries.get(position).getLocationPrice()));
        holder.img.setImageResource(countries.get(position).getLocationImage());

        if (getItemId(position) == 0) {
            // set selected background color by default for 1st item because by default first item selected
            convertView.setBackgroundColor(Color.parseColor("#4D2257F6"));
        }

        return convertView;
    }

    static class ViewHolder{
        //create attributes that match the components of list_row.xml
        private TextView name,price;
        private ImageView img;

    }



}
