package com.example.administrator.dailynote.Home;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.dailynote.Base.BasePresenter;

public interface HomePresenter extends BasePresenter {

    interface HomeView {
        void setAdapter(RecyclerView.Adapter adapter);

    }
}
