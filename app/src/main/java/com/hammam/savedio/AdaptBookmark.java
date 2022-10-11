package com.hammam.savedio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptBookmark extends BaseAdapter {

    List<MyBookmark> bookmarksList;
    Context context;

    public AdaptBookmark(Context context,List<MyBookmark> bookmarksList){
        this.bookmarksList=bookmarksList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return bookmarksList.size();
    }

    @Override
    public Object getItem(int i) {
        return bookmarksList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        MyHolder myHolder = null;

        if (myHolder==null){
            myHolder = new MyHolder();
            view = layoutInflater.inflate(R.layout.lvmain_item,null);
            myHolder.tv_item_title = (TextView) view.findViewById(R.id.tv_item_title);
            myHolder.tv_item_url = (TextView) view.findViewById(R.id.tv_item_url);
            myHolder.ib_open_url = (ImageView) view.findViewById(R.id.ib_open_url);

            view.setTag(myHolder);
        } else if(view != null){
            myHolder = (MyHolder) view.getTag();
        }

        myHolder.tv_item_title.setText(bookmarksList.get(i).bk_title);
        myHolder.tv_item_url.setText(bookmarksList.get(i).bk_url);

        myHolder.ib_open_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openIntent = new Intent(Intent.ACTION_VIEW);
                openIntent.setData(Uri.parse(bookmarksList.get(i).bk_url));
                context.startActivity(openIntent);
            }
        });

        return view;
    }

    private class MyHolder{
        TextView tv_item_title,tv_item_url;
        ImageView ib_open_url;
    }
}
