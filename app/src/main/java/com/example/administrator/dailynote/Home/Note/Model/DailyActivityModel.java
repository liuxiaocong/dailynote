package com.example.administrator.dailynote.Home.Note.Model;

/**
 * Created by LiuXiaocong on 7/29/2016.
 */
public class DailyActivityModel {

    //format 201607291730
    public Long mTime;
    public String mNote;

    public DailyActivityModel(Long time, String note) {
        mTime = time;
        mNote = note;
    }
}
