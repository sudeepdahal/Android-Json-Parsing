package com.example.sudip.rest_race;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sudip on 8/30/2016.
 */
public class Adapter extends ArrayAdapter<Flowers>{
    Context context;
    List<Flowers> flowerses;

    public Adapter(Context context, int resource, List<Flowers> fobjects) {
        super(context, resource, fobjects);
        this.context = context;
        this.flowerses = fobjects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custum_layout,parent,false);
        TextView name,category;
        ImageView image;
        name = (TextView) view.findViewById(R.id.name);
        category = (TextView) view.findViewById(R.id.category);
        image=(ImageView)view.findViewById(R.id.image);

        Flowers flowers = flowerses.get(position);

        name.setText(flowers.getName());
        category.setText(flowers.getCategory());

        Picasso.with(context).load(flowers.getPhoto()).into(image);
        return view;
       // return super.getView(position);// convertView, parent);
    }
}
