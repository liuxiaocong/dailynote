package com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays;

import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.dailynote.Base.BasePresenter;
import com.example.administrator.dailynote.Base.BaseView;
import com.example.administrator.dailynote.Home.Note.Model.DailyActivityModel;

import java.util.List;

public interface NoteDaysPresenter extends BasePresenter {

    interface NoteDayView extends BaseView {
        //empty method
        void base();
        void setAdapter(RecyclerView.Adapter adapter);
        void showLoading();
        void hideLoading();
        View getRoot();
    }


    List<DailyActivityModel> loadActivityList();
}
