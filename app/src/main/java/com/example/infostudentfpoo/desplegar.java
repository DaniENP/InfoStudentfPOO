package com.example.infostudentfpoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class desplegar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.mainMenu:
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            break;
                        case R.id.main_Chat:
                            startActivity(new Intent(getApplicationContext(), Main_Chat.class));
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav,
                            selectedFragment).commit();
                    return true;
                }
            };
}