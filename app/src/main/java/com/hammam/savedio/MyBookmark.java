package com.hammam.savedio;

import com.google.gson.annotations.SerializedName;

public class MyBookmark {

    @SerializedName("bk_id")
    String bk_id;

    @SerializedName("bk_url")
    String bk_url;
    @SerializedName("bk_title")
    String bk_title;
    @SerializedName("bk_note")
    String bk_note;
    @SerializedName("bk_date")
    String bk_date;



    public MyBookmark(){}

    public MyBookmark(String bk_id, String bk_url, String bk_title, String bk_note, String bk_date){
        this.bk_id=bk_id;
        this.bk_url=bk_url;
        this.bk_title=bk_title;
        this.bk_note=bk_note;
        this.bk_date=bk_date;
    }

    public void setBk_id(String bk_id) {
        this.bk_id = bk_id;
    }

    public void setBk_url(String bk_url) {
        this.bk_url = bk_url;
    }

    public void setBk_title(String bk_title) {
        this.bk_title = bk_title;
    }

    public void setBk_note(String bk_note) {
        this.bk_note = bk_note;
    }

    public void setBk_date(String bk_date) {
        this.bk_date = bk_date;
    }

    public String getBk_id() {
        return bk_id;
    }

    public String getBk_url() {
        return bk_url;
    }

    public String getBk_title() {
        return bk_title;
    }

    public String getBk_note() {
        return bk_note;
    }

    public String getBk_date() {
        return bk_date;
    }
}
