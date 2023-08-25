package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dabaewo1.R;
import com.example.dabaewo1.fragment.MainMenuHomeFragment;
import com.example.dabaewo1.fragment.MainMenuMypageFragment;
import com.example.dabaewo1.fragment.MainMenuReserveFragment;
import com.example.dabaewo1.fragment.MainMenuSearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
    private MainMenuSearchFragment fragmentSearch = new MainMenuSearchFragment();
    private MainMenuMypageFragment fragmentMypage = new MainMenuMypageFragment();
    private MainMenuReserveFragment fragmentReserve = new MainMenuReserveFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            int itemId = menuItem.getItemId();
            if (itemId == R.id.menu_home) {
                transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
            } else if (itemId == R.id.menu_search) {
                transaction.replace(R.id.menu_frame_layout, fragmentSearch).commitAllowingStateLoss();
            } else if (itemId == R.id.menu_reserve) {
                transaction.replace(R.id.menu_frame_layout, fragmentReserve).commitAllowingStateLoss();
            } else if (itemId == R.id.menu_mypage) {
                transaction.replace(R.id.menu_frame_layout, fragmentMypage).commitAllowingStateLoss();
            }

            // 다른 case 문을 추가하세요.

            return true;
        }
    }
}
