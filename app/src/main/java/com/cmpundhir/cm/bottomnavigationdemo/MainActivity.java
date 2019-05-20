package com.cmpundhir.cm.bottomnavigationdemo;

import android.net.Uri;
import android.os.Bundle;

import com.cmpundhir.cm.bottomnavigationdemo.fragments.DashBoardFragment;
import com.cmpundhir.cm.bottomnavigationdemo.fragments.HomeFragment;
import com.cmpundhir.cm.bottomnavigationdemo.fragments.MyProfileFragment;
import com.cmpundhir.cm.bottomnavigationdemo.fragments.NotificationFragment;
import com.cmpundhir.cm.bottomnavigationdemo.fragments.OnFragmentInteractionListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(HomeFragment.newInstance("",""));
                    return true;
                case R.id.navigation_dashboard:
                    setFragment(DashBoardFragment.newInstance("",""));
                    return true;
                case R.id.navigation_notifications:
                    setFragment(NotificationFragment.newInstance("",""));
                    return true;
                case R.id.navigation_profile:
                    setFragment(MyProfileFragment.newInstance("",""));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(HomeFragment.newInstance("",""));
    }

    private void setFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
