package com.example.administrator.dailynote.Home.History;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.dailynote.Base.BasePresenter;

public interface FragmentHistoryPresenter extends BasePresenter {

    interface HistoryView {
        void setAdapter(RecyclerView.Adapter adapter);
    }
}
