package com.example.dung.music_59.ui.home;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.dung.music_59.R;
import com.example.dung.music_59.ui.adapter.ViewPagerAdapter;
import com.example.dung.music_59.ui.home.homefragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static final int PAGE_LIMIT = 3;
    private static final int PAGE_HOME = 0;
    private static final int PAGE_USER = 1;
    private static final int PAGE_DOWLOAD = 2;
    private ViewPager mViewPagerHome;
    private TabLayout mTabLayoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUpViewPager();
        setupTabIcon();
        setToolbar();
    }

    private void setToolbar() {
        Toolbar mToolbarHome = findViewById(R.id.tool_bar_home);
        setSupportActionBar(mToolbarHome);
        getSupportActionBar().setTitle(R.string.title_music_59);
    }

    private void setUpViewPager() {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new HomeFragment(), getString(R.string.title_home));
        pagerAdapter.addFragment(new UserFragment(), getString(R.string.title_user));
        pagerAdapter.addFragment(new DowloadFragment(), getString(R.string.title_dowload));
        mViewPagerHome.setAdapter(pagerAdapter);
        mViewPagerHome.setOffscreenPageLimit(PAGE_LIMIT);
    }

    private void initView() {
        mViewPagerHome = findViewById(R.id.view_pager);
        mTabLayoutHome = findViewById(R.id.tab_layout);
        mTabLayoutHome.setupWithViewPager(mViewPagerHome);
    }

    public void setupTabIcon() {
        mTabLayoutHome.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.color_accent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getApplicationContext(), R.color.color_black);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayoutHome.getTabAt(PAGE_HOME).setIcon(R.drawable.ic_home_white_24dp);
        mTabLayoutHome.getTabAt(PAGE_USER).setIcon(R.drawable.ic_account_circle_white_24dp);
        mTabLayoutHome.getTabAt(PAGE_DOWLOAD).setIcon(R.drawable.ic_file_download_white_24dp);
    }
}
