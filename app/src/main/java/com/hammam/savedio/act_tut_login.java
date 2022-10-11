package com.hammam.savedio;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hammam.savedio.tut.Fra1;
import com.hammam.savedio.tut.Fra2;
import com.hammam.savedio.tut.Fra3;
import com.hammam.savedio.tut.Fra4;
import com.hammam.savedio.tut.Fra5;

import java.util.ArrayList;

public class act_tut_login extends AppCompatActivity {

    ArrayList<Fragment> FragmentList;

    ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tut_login);

        FragmentList = new ArrayList<Fragment>();
        Fra1 fra1 = new Fra1();
        Fra2 fra2 = new Fra2();
        Fra3 fra3 = new Fra3();
        Fra4 fra4 = new Fra4();
        Fra5 fra5 = new Fra5();
        FragmentList.add(fra1);
        FragmentList.add(fra2);
        FragmentList.add(fra3);
        FragmentList.add(fra4);
        FragmentList.add(fra5);

        view_pager = (ViewPager) findViewById(R.id.view_pager);
        Adapt_Pager adapt_pager = new Adapt_Pager(getSupportFragmentManager(),FragmentList);
        view_pager.setAdapter(adapt_pager);

    }

    public void ednTut(){
        Intent intent = new Intent(act_tut_login.this,act_web.class);
        startActivity(intent);
        finish();
        return;
    }
}