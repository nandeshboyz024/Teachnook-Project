package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView listView;
    String s1,s2;

    CustomListAdapter adapter;
    public ArrayList<CustomListPOJO> arr_bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout =findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent i = getIntent();
        s1 = i.getStringExtra("Key_name");
        s2 = i.getStringExtra("Key_email");


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.i1){
                   // Toast.makeText(MainActivity.this, "ello", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.i2){

                  //  Toast.makeText(MainActivity.this, "efghjllo", Toast.LENGTH_SHORT).show();

                    Intent i= new Intent(getApplicationContext(),Information.class);
                    i.putExtra("Key_name",s1);
                    i.putExtra("Key_email",s2);
                    startActivity(i);
                }
                else if(id==R.id.i3){
                    //Toast.makeText(MainActivity.this, "djjhg", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Cart.class);
                    intent.putExtra("Key_name",s1);
                    intent.putExtra("Key_email",s2);
                    startActivity(intent);
                }
                else {
                   // Toast.makeText(MainActivity.this, "sdfgghgy", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Registration.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        listView =(ListView)findViewById(R.id.listview);
        arr_bean = new ArrayList<CustomListPOJO>();

        arr_bean.add(new CustomListPOJO(R.drawable.seabuckthorn,"WINZERA\nSea Buckthorn Oil","Rs: 1400"));
        arr_bean.add(new CustomListPOJO(R.drawable.bag,"FUR JADEN\nBrown Bag","Rs: 8199"));
        arr_bean.add(new CustomListPOJO(R.drawable.bati_maker,"ANCHARA\nBati Maker","Rs: 711"));
        arr_bean.add(new CustomListPOJO(R.drawable.bed_set,"AMAZON\nBed set","Rs: 3259"));
        arr_bean.add(new CustomListPOJO(R.drawable.decorative_items,"DARTISTRY\nDecorative Items","Rs: 1199"));
        arr_bean.add(new CustomListPOJO(R.drawable.iphone,"APPLE\nIphone 14 Pro 256GB","Rs: 1,39,900"));
        arr_bean.add(new CustomListPOJO(R.drawable.magy_mixy,"BAJAJ\nMaggi Mixer","Rs: 1999"));
        arr_bean.add(new CustomListPOJO(R.drawable.t_shirt,"ALLEN SOLLY\nFit -T shirt","Rs: 359"));
        arr_bean.add(new CustomListPOJO(R.drawable.watch,"SPICY\nCombo Watch","Rs: 1777"));
        arr_bean.add(new CustomListPOJO(R.drawable.maker_space,"MC-GRAW\nMaker Space","Rs: 1302"));

        adapter = new CustomListAdapter(arr_bean,this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}