package com.example.administrator.dailynote.Home.Note;

import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.dailynote.Base.BasePresenter;
import com.example.administrator.dailynote.Base.BaseView;

public interface FragmentNotePresenter extends BasePresenter {

    void init();
    interface NoteView extends BaseView {
        void setViewPagerAdapter(FragmentPagerAdapter fragmentPagerAdapter);
        FragmentManager getLFragmentManager();
    }
}
