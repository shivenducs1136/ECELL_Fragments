package com.example.kiete_cell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadFragments(new HOME());
        bottomNavigationView = findViewById(R.id.menu_items);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    public boolean loadFragments(Fragment fragment){

        if(fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.parent_container,fragment)
                    .commit();

        }

        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment=null;

        switch (item.getItemId()){
            case R.id.home:
                fragment=new HOME();
                break;
            case R.id.home1:
                fragment=new HOME1();
                break;
            case R.id.home2:
                fragment=new HOME2();
                break;
            case R.id.home3:
                fragment=new HOME3();
                break;
        }

        return loadFragments(fragment);
    }
}