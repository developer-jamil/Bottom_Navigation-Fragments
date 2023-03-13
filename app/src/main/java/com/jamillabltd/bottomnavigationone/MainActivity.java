package com.jamillabltd.bottomnavigationone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jamillabltd.bottomnavigationone.BottomFragments.CartFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.HomeFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.MessageFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        //default fragment set - HomeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        //bottom navigation setOnItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.menu_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.menu_message:
                    selectedFragment = new MessageFragment();
                    break;
                case R.id.menu_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.menu_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }


    @Override
    public void onBackPressed() {
        if (bottomNavigationView.getSelectedItemId() == R.id.menu_home) {
            super.onBackPressed();
            finish();
        }else{
            bottomNavigationView.setSelectedItemId(R.id.menu_home);
        }
    }
}