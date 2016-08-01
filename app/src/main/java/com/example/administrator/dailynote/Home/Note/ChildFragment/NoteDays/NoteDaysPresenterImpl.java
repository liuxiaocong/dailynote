package com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays;

import android.support.design.widget.Snackbar;

import com.example.administrator.dailynote.Base.BasePresenterImpl;
import com.example.administrator.dailynote.Common.DailyNoteAdapter;
import com.example.administrator.dailynote.Home.Note.Model.DailyActivityModel;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        mView.showLoading();
        loadActivityListRX(new Observer() {
            @Override
            public void onCompleted() {
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                Snackbar.make(mView.getRoot(), "Error when load daily record", Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onNext(Object o) {
                mDailyNoteAdapter.setData(mDailyActivityModelArrayList);
                mView.setAdapter(mDailyNoteAdapter);
            }
        });
    }

    private void loadActivityListRX(rx.Observer observer) {
        rx.Observable.create(new rx.Observable.OnSubscribe<List<DailyActivityModel>>() {
            @Override
            public void call(Subscriber<? super List<DailyActivityModel>> subscriber) {
                try {
                    Thread.sleep(2000);
                    loadActivityList();
                    subscriber.onNext(mDailyActivityModelArrayList);
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                    subscriber.onCompleted();
                    e.printStackTrace();
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


    @Override
    public List<DailyActivityModel> loadActivityList() {
        int step = 30;
        for (Long i = 201607290000L; i < 201607292400L; i = i + step) {
            if (i % 100 == 0) {
                step = 30;
            } else {
                step = 70;
            }
            DailyActivityModel dailyActivityModel = new DailyActivityModel(i, "note");
            mDailyActivityModelArrayList.add(dailyActivityModel);
        }
        return mDailyActivityModelArrayList;
    }

    private DailyNoteAdapter.DailyNoteAdapterListener mDailyNoteAdapterListener = new DailyNoteAdapter.DailyNoteAdapterListener() {

    };
}
