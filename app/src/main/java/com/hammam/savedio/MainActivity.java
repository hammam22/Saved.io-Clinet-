package com.hammam.savedio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hammam.savedio.tut.Fra1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //onactivity result come from delete
    //add bookmark
    //openurl

    //logout with key = "" in sp

    String key = "JXpjjDTi5LHoCaTUs6wcBpQIgFB08G1W";
    String devkey = "LE02ylhtAOTBU8vxFufFzwocdKcnl5ou";
    ListView lvmain;
    TextView tvmainEmpty;
    FloatingActionButton faMain;



    Di_addNew di_addNew;

    List<MyBookmark> bookmarks;
    AdaptBookmark adaptBookmark;
    private int requestTOBOOKMARK=91;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = context.getSharedPreferences("key",MODE_PRIVATE);
        key=sp.getString("key","");






        faMain = (FloatingActionButton) findViewById(R.id.faMain);
        faMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                di_addNew = new Di_addNew(context);
                di_addNew.show();
            }
        });


        lvmain = findViewById(R.id.lvmain);
        lvmain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),act_Bookmark_details.class);
                intent.putExtra("id",bookmarks.get(i).bk_id);
                intent.putExtra("title",bookmarks.get(i).bk_title);
                intent.putExtra("url",bookmarks.get(i).bk_url);
                intent.putExtra("devkey",devkey);
                intent.putExtra("key",key);
                intent.putExtra("i",i);
                startActivityForResult(intent,requestTOBOOKMARK);
            }
        });
        tvmainEmpty = findViewById(R.id.tvmainEmpty);



        Call<List<MyBookmark>> call = Api.getClient().getAllBookmarks(devkey, key);

        call.enqueue(new Callback<List<MyBookmark>>() {
            @Override
                public void onResponse(Call<List<MyBookmark>> call, Response<List<MyBookmark>> response) {
                if (response.message().equals("Forbidden")){
                    Toast.makeText(context,"Wrong API Key",Toast.LENGTH_LONG).show();
                    SharedPreferences sp = context.getSharedPreferences("key",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("key","");
                    editor.commit();
                    startActivity(new Intent(context,act_Login.class));
                    finish();
                    return;
                } else {
                    bookmarks = response.body();
                }

                updateLV();
            }

            @Override
                public void onFailure(Call<List<MyBookmark>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG);
                Log.d("MainActivity", t.getMessage());
                updateLV();
                }
            });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.action_logout){
            SharedPreferences sp = context.getSharedPreferences("key",MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("key","");
            editor.commit();
            Intent intent = new Intent(context,act_Login.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

    private void updateLV() {
        if (bookmarks==null){
            tvmainEmpty.setVisibility(View.VISIBLE);
            lvmain.setVisibility(View.INVISIBLE);
        }else {
            tvmainEmpty.setVisibility(View.INVISIBLE);
            lvmain.setVisibility(View.VISIBLE);
            adaptBookmark = new AdaptBookmark(this,bookmarks);
            lvmain.setAdapter(adaptBookmark);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==requestTOBOOKMARK && resultCode==RESULT_OK){
            int i = data.getIntExtra("i",0);
            bookmarks.remove(i);
            updateLV();
        }

    }

    public void createBoo(String newurl, String newtitle){

        Call call = Api.getClient().createBookmark(devkey,key,newurl,newtitle);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                bookmarks.add(new MyBookmark(
                        response.body().toString(),newurl,newtitle,null,null
                ));
                updateLV();
                di_addNew.dismiss();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

}