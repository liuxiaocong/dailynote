package com.example.administrator.dailynote.Base;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class BaseActivity extends AppCompatActivity {
    private String globeTAG = "Daily";

    private void DLog(String tag, String content) {
        Log.d(tag, content);
    }
}
