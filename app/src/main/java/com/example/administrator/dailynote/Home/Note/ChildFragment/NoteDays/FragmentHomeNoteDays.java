package com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.administrator.dailynote.Base.BaseFragment;
import com.example.administrator.dailynote.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class FragmentHomeNoteDays extends BaseFragment implements NoteDaysPresenter.NoteDayView {
    private View mRoot;
    private EDayType mEDayType;
    @BindView(R.id.note_list)
    RecyclerView mRecyclerView;
    String TAG = "FragmentHomeNoteDays";
    NoteDaysPresenter mNoteDaysPresenter;
    @BindView(R.id.loading)
    ProgressBar mLoading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoteDaysPresenter = new NoteDaysPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.DLog(TAG, "onCreateView");
        mRoot = inflater.inflate(R.layout.home_note_days, container, false);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.DLog(TAG, "onViewCreated");
        ButterKnife.bind(this, mRoot);
        initUi();
    }

    public void setDayType(EDayType eDayType) {
        this.DLog(TAG, "setDayType");
        mEDayType = eDayType;
    }

    private void initUi() {
        if (mEDayType.equals(EDayType.EToday)) {
            setTodayStyle();
        } else if (mEDayType.equals(EDayType.EYesterday)) {
            setYesterdayStyle();
        } else {
            setTomorrowStyle();
        }
        ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(true);
        mNoteDaysPresenter.onUIReady();

    }

    private void setYesterdayStyle() {

        mRoot.setBackgroundColor(Color.parseColor("#ee8800"));
    }

    private void setTodayStyle() {

        mRoot.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void setTomorrowStyle() {

        mRoot.setBackgroundColor(Color.parseColor("#ee9900"));
    }

    @Override
    public void base() {

    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public View getRoot() {
        return mRoot;
    }

    @Override
    public Context getLContext() {
        return getActivity();
    }
}
