package com.example.minhthanh.lfcnews;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mDrawerList;
    ArrayAdapter<String> mAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    String mActivityTitle;
    ArrayList<android.support.v4.app.Fragment> fragmentList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        addFragment();
        addProcess();
        setupDrawer();
    }

    private void addFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentMain());
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());

        FragmentManager fm = getSupportFragmentManager();
        getSupportActionBar().setTitle("Home");
        fm.beginTransaction().replace(R.id.linear_layout, new FragmentMain()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            invalidateOptionsMenu();
            return true;
        }
        return false;
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void addProcess() {
        String[] titles = {"Home", "News", "Matches", "About"};
        mAdapter = new ListAdapter(MainActivity.this, R.layout.list_layout, titles);
        mDrawerList.setAdapter(mAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mActivityTitle = getTitle().toString();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                android.support.v4.app.Fragment fragment = null;
                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (position) {
                    case 0:
                        fragment = fragmentList.get(position);
                        getSupportActionBar().setTitle("Home");
                        break;
                    case 1:
                        fragment = fragmentList.get(position);
                        getSupportActionBar().setTitle("Latest News");
                        break;
                    case 2:
                        fragment = fragmentList.get(position);
                        getSupportActionBar().setTitle("Matches");
                        break;
                    case 3:
                        fragment = fragmentList.get(position);
                        getSupportActionBar().setTitle("About");
                        break;
                    default:
                        fragment = fragmentList.get(0);
                        break;
                }
                mDrawerLayout.closeDrawers();
                fragmentManager.beginTransaction().replace(R.id.linear_layout, fragment).commit();
            }
        });
    }

    private void addControl() {
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
