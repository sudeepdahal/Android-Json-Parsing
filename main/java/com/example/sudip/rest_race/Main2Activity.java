package com.example.sudip.rest_race;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    TextView tv1,tv2;
    String url;
    RequestQueue queue;
    Adapter adapter;
    List<Flowers> flowersList;
    ListView lv;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        flowersList=new ArrayList<>();

        lv=(ListView)findViewById(R.id.list_view);
        //tv1=(TextView)findViewById(R.id.textView);
       // tv2=(TextView)findViewById(R.id.textView2);
        pb= (ProgressBar) findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);

        queue= Volley.newRequestQueue(this);
        url="http://services.hanselandpetal.com/feeds/flowers.json";
        StringRequest stringRequest=new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jar=new JSONArray(response);
                    for (int i = 0; i < jar.length(); i++) {
                        pb.setVisibility(View.INVISIBLE);
                        JSONObject obj=jar.getJSONObject(i);
                        String name=obj.getString("name");
                        String category=obj.getString("category");
                        int productId=obj.getInt("productId");
                        String instructions=obj.getString("instructions");
                        String photo=obj.getString("photo");
                        double price=obj.getDouble("price");

                        Flowers fl=new Flowers();
                        fl.setName(name);
                        fl.setCategory(category);
                        fl.setInstruction(instructions);
                        fl.setPhoto("http://services.hanselandpetal.com/photos/"+photo);
                        fl.setPrice(price);
                        fl.setProductid(productId);

                        flowersList.add(fl);

                        Log.d("n1",name);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //tv2.setText(response);

                adapter = new Adapter(getApplicationContext(),R.layout.custum_layout,flowersList);
               lv.setAdapter(adapter);
           // Log.d("Res",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
            }
        });
        queue.add(stringRequest);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Flowers flowers=flowersList.get(position);
                Intent in=new Intent(getApplicationContext(),Detail_Info.class);

                String n=flowers.getName();
                in.putExtra("na",n);
                in.putExtra("nim",flowers.getPhoto());
                in.putExtra("npr",String.valueOf(flowers.getPrice()));
                in.putExtra("ncat",flowers.getCategory());
                in.putExtra("npid",String.valueOf(flowers.getProductid()));
                in.putExtra("nins",String.valueOf(flowers.getInstruction()));

                startActivity(in);

            }
        });
    }
}
