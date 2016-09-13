package com.example.sudip.rest_race;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail_Info extends AppCompatActivity {
    TextView textView,textView2,textView3,textView4,textView5;
    ImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__info);
        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);
        textView4=(TextView) findViewById(R.id.textView4);
        textView5=(TextView) findViewById(R.id.textView5);

        iv3= (ImageView) findViewById(R.id.imageView3);

        Intent in=getIntent();
        String nn=in.getStringExtra("na");
        textView.setText(nn);
        String npr=in.getStringExtra("npr");
        textView2.setText(npr);
        String ncat=in.getStringExtra("ncat");
        textView3.setText(ncat);
        String npid=in.getStringExtra("npid");
        textView4.setText(npid);
        String nins=in.getStringExtra("nins");
        textView5.setText(nins);

        String nimg=in.getStringExtra("nim");
        Picasso.with(Detail_Info.this).load(nimg).into(iv3);
    }
}
