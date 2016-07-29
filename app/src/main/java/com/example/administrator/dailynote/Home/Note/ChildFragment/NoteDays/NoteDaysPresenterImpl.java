package com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays;

import com.example.administrator.dailynote.Base.BasePresenterImpl;
import com.example.administrator.dailynote.Common.DailyNoteAdapter;
import com.example.administrator.dailynote.Home.Note.Model.DailyActivityModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class NoteDaysPresenterImpl extends BasePresenterImpl implements NoteDaysPresenter {
    private NoteDayView mView;

    public NoteDaysPresenterImpl(NoteDayView view) {
        mView = view;
    }

    private DailyNoteAdapter mDailyNoteAdapter;
    ArrayList<DailyActivityModel> mDailyActivityModelArrayList = new ArrayList<>();

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onUIReady() {
        mDailyNoteAdapter = new DailyNoteAdapter(mView.getLContext(), mDailyNoteAdapterListener);
        loadActivityList();
        mDailyNoteAdapter.setData(mDailyActivityModelArrayList);
        mView.setAdapter(mDailyNoteAdapter);
    }


    @Override
    public List<DailyActivityModel> loadActivityList() {
        for (Long i = 201607290000L; i < 201607292400L; i = i + 30) {
            DailyActivityModel dailyActivityModel = new DailyActivityModel(i, "note");
            mDailyActivityModelArrayList.add(dailyActivityModel);
        }
        return mDailyActivityModelArrayList;
    }

    private DailyNoteAdapter.DailyNoteAdapterListener mDailyNoteAdapterListener = new DailyNoteAdapter.DailyNoteAdapterListener() {

    };
}
