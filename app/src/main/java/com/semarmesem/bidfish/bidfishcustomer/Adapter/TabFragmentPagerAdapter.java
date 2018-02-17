package com.semarmesem.bidfish.bidfishcustomer.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.semarmesem.bidfish.bidfishcustomer.Fragment.HomeFragment;
import com.semarmesem.bidfish.bidfishcustomer.Fragment.ProfileFragment;

/**
 * Created by lenovo on 05/02/2018.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    String [] tabTitle = new String[] {
            "Home", "Profile"
    };

    public TabFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0 :
                fragment = new HomeFragment();
                break;
            case 1 :
                fragment = new ProfileFragment();
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
}
