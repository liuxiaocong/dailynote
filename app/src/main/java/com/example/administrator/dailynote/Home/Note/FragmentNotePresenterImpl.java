package com.example.administrator.dailynote.Home.Note;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.example.administrator.dailynote.Base.BasePresenterImpl;
import com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays.EDayType;
import com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays.FragmentHomeNoteDays;
import com.example.administrator.dailynote.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class FragmentNotePresenterImpl extends BasePresenterImpl implements FragmentNotePresenter {
    private NoteView mView;
    ViewPagerAdapter mAdapter;
    FragmentHomeNoteDays mFragmentHomeNoteDaysYesterday;
    FragmentHomeNoteDays mFragmentHomeNoteDaysToday;
    FragmentHomeNoteDays mFragmentHomeNoteDaysTomorrow;
    public FragmentNotePresenterImpl(NoteView view) {
        mView = view;
    }

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

    }

    @Override
    public void init() {
        mAdapter = new ViewPagerAdapter(mView.getLFragmentManager());
        mFragmentHomeNoteDaysYesterday = new FragmentHomeNoteDays();
        mFragmentHomeNoteDaysYesterday.setDayType(EDayType.EYesterday);
        mAdapter.addFragment(mFragmentHomeNoteDaysYesterday, mView.getLContext().getResources().getString(R.string.yesterday));
        mFragmentHomeNoteDaysToday = new FragmentHomeNoteDays();
        mFragmentHomeNoteDaysToday.setDayType(EDayType.EToday);
        mAdapter.addFragment(mFragmentHomeNoteDaysToday, mView.getLContext().getResources().getString(R.string.today));
        mFragmentHomeNoteDaysTomorrow = new FragmentHomeNoteDays();
        mFragmentHomeNoteDaysTomorrow.setDayType(EDayType.ETomorrow);
        mAdapter.addFragment(mFragmentHomeNoteDaysTomorrow, mView.getLContext().getResources().getString(R.string.tomorrow));
        mView.setViewPagerAdapter(mAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
