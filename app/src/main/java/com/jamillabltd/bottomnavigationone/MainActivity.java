package com.jamillabltd.bottomnavigationone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jamillabltd.bottomnavigationone.BottomFragments.CartFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.HomeFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.MessageFragment;
import com.jamillabltd.bottomnavigationone.BottomFragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bottom navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }


    //bottom navigation icon click
    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            };


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