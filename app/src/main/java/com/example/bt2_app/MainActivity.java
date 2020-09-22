package com.example.bt2_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bt2_app.adapter.PagerAdapter;
import com.example.bt2_app.fragment.FragmentChat;
import com.example.bt2_app.fragment.FragmentHome;
import com.example.bt2_app.fragment.FragmentMyPager;
import com.example.bt2_app.fragment.FragmentNew;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Home");

        mDrawerLayout = findViewById(R.id.drawerMain);
        mNavigationView = findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(this);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mActionBarDrawerToggle.syncState();

        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addData(new FragmentHome(), "Home");
        adapter.addData(new FragmentChat(), "Chat");
        adapter.addData(new FragmentNew(), "New");
        adapter.addData(new FragmentMyPager(), "My pager");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        final int tabIconColorSelect = ContextCompat.getColor(getApplication(), android.R.color.white);
        final int tabIconColor = ContextCompat.getColor(getApplication(), android.R.color.black);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home_while);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_chat_while);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_fiber_new_while);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_pages_while);


        mTabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        mTabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        mTabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.getIcon().setColorFilter(tabIconColorSelect, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        tab.getIcon().setColorFilter(tabIconColorSelect, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColorSelect, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    case 2:
                        tab.getIcon().setColorFilter(tabIconColorSelect, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

                        break;
                    case 3:
                        tab.getIcon().setColorFilter(tabIconColorSelect, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(1).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(2).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        mTabLayout.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.itemHome:
                intent = new Intent(MainActivity.this, SplashActivity.class);
                startIntent(intent);
                return true;
            case R.id.itemChat:
                intent = new Intent(MainActivity.this, SplashActivity.class);
                startIntent(intent);
                return true;
            case R.id.itemNew:
                intent = new Intent(MainActivity.this, SplashActivity.class);
                startIntent(intent);
                return true;
        }

        return false;
    }

    private void startIntent(Intent intent) {
        startActivity(intent);
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}