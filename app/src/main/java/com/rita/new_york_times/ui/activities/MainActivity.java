package com.rita.new_york_times.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rita.new_york_times.R;
import com.rita.new_york_times.ui.ViewPagerAdapter;
import com.rita.new_york_times.ui.fragments.FragmentEmailed;
import com.rita.new_york_times.ui.fragments.FragmentShared;
import com.rita.new_york_times.ui.fragments.FragmentStarred;
import com.rita.new_york_times.ui.fragments.FragmentViewed;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private FragmentStarred fragmentStarred = new FragmentStarred();


    public FragmentStarred getFragmentStarred() {
        return fragmentStarred;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.view_pager_id);
        adapter = new ViewPagerAdapter((getSupportFragmentManager()));

        adapter.AddFragment(new FragmentEmailed(), "Emailed");
        adapter.AddFragment(new FragmentViewed(), "Viewed");
        adapter.AddFragment(new FragmentShared(), "Shared");
        adapter.AddFragment(fragmentStarred, "");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_star_black);
    }
}
