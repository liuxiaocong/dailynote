package com.example.administrator.dailynote.Base;

import android.app.Fragment;
import android.util.Log;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class BaseFragment extends Fragment {
    private String globeTAG = "Daily";

    protected void DLog(String content) {
        Log.d(globeTAG, content);
    }
    protected void DLog(String tag, String content) {
        Log.d(tag, content);
    }
}
