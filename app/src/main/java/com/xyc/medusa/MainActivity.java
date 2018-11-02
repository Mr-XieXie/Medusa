package com.xyc.medusa;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xyc.medusa.Fragment.FirstFragment;
import com.xyc.medusa.Fragment.FourthFragment;
import com.xyc.medusa.Fragment.SecondFragment;
import com.xyc.medusa.Fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);

        initNavigationBar();
        initFragment();
    }

    private void initNavigationBar() {
        final BottomNavigationBar mBottomNavigationBar = findViewById(R.id.main_bottom_nav_bar);
        //设置BottomNavigationBar效果
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        mBottomNavigationBar.setActiveColor(R.color.mainOrange).setInActiveColor(R.color.mainGray);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home_gray,R.string.index))
                .addItem(new BottomNavigationItem(R.drawable.list_gray,R.string.mission))
                .addItem(new BottomNavigationItem(R.drawable.find_gray,R.string.find))
                .addItem(new BottomNavigationItem(R.drawable.mine_gray,R.string.mine))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (position){
                    case 0:
                        if(firstFragment==null){
                            firstFragment = new FirstFragment();
                        }
                        transaction.replace(R.id.main_frame_layout,firstFragment);
                        break;
                    case 1:
                        if(secondFragment==null){
                            secondFragment = new SecondFragment();
                        }
                        transaction.replace(R.id.main_frame_layout,secondFragment);
                        break;
                    case 2:
                        if(thirdFragment == null){
                            thirdFragment = new ThirdFragment();
                        }
                        transaction.replace(R.id.main_frame_layout,thirdFragment);
                        break;
                    case 3:
                        if(fourthFragment == null){
                            fourthFragment = new FourthFragment();
                        }
                        transaction.replace(R.id.main_frame_layout,fourthFragment);
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void initFragment() {
        firstFragment = new FirstFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame_layout,firstFragment);
        transaction.commit();
    }
}
