package com.hammam.savedio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class act_Bookmark_details extends AppCompatActivity {

    //open url


    //delete url

    String title,url,id,devkey,key;
    TextView tv_bookmark_title,tv_bookmark_url,tv_bookmark_delete;
    Button bt_bookmark_delete;
    int i;
    private int requestTOBOOKMARK=91;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bookmark_details);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("title");
        url = intent.getStringExtra("url");
        devkey = intent.getStringExtra("devkey");
        key = intent.getStringExtra("key");
        i = intent.getIntExtra("i",0);

        tv_bookmark_title = (TextView) findViewById(R.id.tv_bookmark_title);
        tv_bookmark_url = (TextView) findViewById(R.id.tv_bookmark_url);
        tv_bookmark_delete = (TextView) findViewById(R.id.tv_bookmark_delete);
        tv_bookmark_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBookmark();
            }
        });
        bt_bookmark_delete = (Button) findViewById(R.id.bt_bookmark_delete);
        bt_bookmark_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBookmark();
            }
        });

        tv_bookmark_title.setText(title);
        tv_bookmark_url.setText(url);
        tv_bookmark_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openIntent = new Intent(Intent.ACTION_VIEW);
                openIntent.setData(Uri.parse(url));
                startActivity(openIntent);
            }
        });
    }

    private void deleteBookmark() {
        Call<ResponseBody> call = Api.getClient().deleteBookmark(devkey,key,id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent exitIntent = new Intent(getApplicationContext(),MainActivity.class);
                exitIntent.putExtra("i",i);
                setResult(RESULT_OK,exitIntent);
                finish();
                return;
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}