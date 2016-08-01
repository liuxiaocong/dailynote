package com.example.administrator.dailynote.Home.Note;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.dailynote.Base.BaseFragment;
import com.example.administrator.dailynote.R;

import butterknife.BindView;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class FragmentHomeNote extends BaseFragment implements FragmentNotePresenter.NoteView {
    private View mRoot;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragmentNotePresenter mFragmentNotePresenter;
    @BindView(R.id.text)
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.home_note, container, false);
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mTabLayout == null) {
            mTabLayout = (TabLayout) mRoot.findViewById(R.id.tabs);
            mViewPager = (ViewPager) mRoot.findViewById(R.id.viewpager);
            mFragmentNotePresenter = new FragmentNotePresenterImpl(this);
            mFragmentNotePresenter.init();
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }


    @Override
    public void setViewPagerAdapter(FragmentPagerAdapter fragmentPagerAdapter) {
        if (mViewPager != null) {
            mViewPager.setAdapter(fragmentPagerAdapter);
            mViewPager.setCurrentItem(1);
        }
    }

    @Override
    public android.app.FragmentManager getLFragmentManager() {
        return getFragmentManager();
    }

    @Override
    public Context getLContext() {
        return getActivity();
    }
}
