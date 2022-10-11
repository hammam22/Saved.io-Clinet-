package com.hammam.savedio.tut;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hammam.savedio.R;
import com.hammam.savedio.act_Login;
import com.hammam.savedio.act_tut_login;

public class Fra5 extends Fragment {


    public Fra5(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fra5, container, false);
        Button bt_end_tut = (Button) view.findViewById(R.id.bt_end_tut);
        bt_end_tut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((act_tut_login) getContext()).ednTut();
            }
        });
        return view;
    }

}
