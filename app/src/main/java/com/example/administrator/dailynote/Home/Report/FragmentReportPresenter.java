package com.example.administrator.dailynote.Home.Report;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.dailynote.Base.BasePresenter;

public interface FragmentReportPresenter extends BasePresenter {

    interface ReportView {
        void setAdapter(RecyclerView.Adapter adapter);
    }
}
