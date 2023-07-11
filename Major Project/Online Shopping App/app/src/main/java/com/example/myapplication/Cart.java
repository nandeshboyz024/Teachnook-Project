package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Cart extends AppCompatActivity {
    String s1,s2;
    Toolbar toolbar2;
    ListView listView2;
    CustomListAdapter2 adapter;
    Button order;
    Data data;
    public ArrayList<CustomListPOJO> arr_bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        order = (Button) findViewById(R.id.order);

        Intent i = getIntent();
        s1=i.getStringExtra("Key_name");
        s2=i.getStringExtra("Key_email");

        toolbar2 =findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        listView2 =(ListView)findViewById(R.id.listview2);
        arr_bean = new ArrayList<CustomListPOJO>();

        data = new Data(Cart.this);
        data.addItems(arr_bean);

        adapter = new CustomListAdapter2(arr_bean,this);
        listView2.setAdapter(adapter);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arr_bean.size()==0){
                    Toast.makeText(Cart.this, "No items in your Cart", Toast.LENGTH_SHORT).show();
                }
                else {
                    data.deleteItems();
                    Intent i = new Intent(getApplicationContext(), Cart.class);
                    i.putExtra("Key_name", s1);
                    i.putExtra("Key_email", s2);
                    startActivity(i);
                    Toast.makeText(Cart.this, "Your order has successfully placed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putExtra("Key_name",s1);
        i.putExtra("Key_email",s2);
        startActivity(i);
    }
}
