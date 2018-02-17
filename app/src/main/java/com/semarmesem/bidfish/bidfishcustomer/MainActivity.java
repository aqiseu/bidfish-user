package com.semarmesem.bidfish.bidfishcustomer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.semarmesem.bidfish.bidfishcustomer.Activity.SliderActivity;
import com.semarmesem.bidfish.bidfishcustomer.Adapter.TabFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout_main)
    TabLayout tabLayoutMain;
    @BindView(R.id.viewPager_main)
    ViewPager viewPagerMain;
    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    String MyPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        setMenuTab();

    }

    private void setMenuTab() {
        viewPagerMain.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

        tabLayoutMain.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorAccent));

        tabLayoutMain.setupWithViewPager(viewPagerMain);
        tabLayoutMain.setTabGravity(TabLayout.GRAVITY_FILL);
    }




}
