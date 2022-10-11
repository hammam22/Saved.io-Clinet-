package com.hammam.savedio;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Di_addNew extends Dialog {

    EditText ed_new_title,ed_new_url;
    Button bt_cancel_new,bt_add_new;
    Context context;

    public Di_addNew(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.di_add_new);

        ed_new_url = (EditText) findViewById(R.id.ed_new_url);
        ed_new_title = (EditText) findViewById(R.id.ed_new_title);

        bt_add_new = (Button) findViewById(R.id.bt_add_new);
        bt_cancel_new = (Button) findViewById(R.id.bt_cancel_new);

        bt_cancel_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        bt_add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url,title;
                url = ed_new_url.getText().toString();
                title = ed_new_title.getText().toString();
                if (url.isEmpty()||title.isEmpty()){
                    Toast.makeText(context,"Fill the data please",Toast.LENGTH_SHORT).show();
                }else {
                    ((MainActivity) context).createBoo(url,title);
                }
            }
        });

    }
}
