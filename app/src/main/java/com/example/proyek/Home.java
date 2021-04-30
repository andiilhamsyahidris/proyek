package com.example.proyek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationItemView = findViewById(R.id.bottom_navigation);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_profile:
                    selectedFragment = new FragmentProfile();
                    break;
                case R.id.nav_inbox:
                    selectedFragment = new FragmentInbox();
                    break;
                case R.id.nav_history:
                    selectedFragment = new FragmentHistory();
                    break;
                case R.id.nav_fav:
                    selectedFragment = new FragmentFav();
                    break;
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
    
}