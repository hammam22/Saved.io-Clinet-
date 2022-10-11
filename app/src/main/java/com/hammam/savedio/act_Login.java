package com.hammam.savedio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class act_Login extends AppCompatActivity {

    Context context = this;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = context.getSharedPreferences("key",MODE_PRIVATE);
        String test = sp.getString("key","");
        if (test.equals("")){

        }else {
            Intent intent = new Intent(context,MainActivity.class);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.act_login);

        EditText ed_key = (EditText) findViewById(R.id.ed_key);
        Button bt_enter = (Button) findViewById(R.id.bt_enter);
        bt_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = ed_key.getText().toString();
                if (key.isEmpty()){
                    Toast.makeText(context,"Please Enter Your Key",Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("key",key);
                    editor.commit();
                    Intent intent = new Intent(context,MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        });
        TextView tv_generate_key = (TextView) findViewById(R.id.tv_generate_key);

        tv_generate_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,act_tut_login.class);
                startActivity(intent);
            }
        });
    }
}