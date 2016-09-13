package com.example.sudip.rest_race;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView iv,iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView);
        iv1=(ImageView)findViewById(R.id.imageView2);
        Picasso.with(MainActivity.this).load("https://upload.wikimedia.org/wikipedia/en/9/99/MarioSMBW.png").into(iv);

         Picasso.with(MainActivity.this).load("http://galeri.uludagsozluk.com/23/super-mario_62246.jpg").into(iv1);

       // Volley
    }
}
