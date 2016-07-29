package com.example.administrator.dailynote.Home;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.dailynote.Base.BaseActivity;
import com.example.administrator.dailynote.Home.History.FragmentHomeHistory;
import com.example.administrator.dailynote.Home.Note.FragmentHomeNote;
import com.example.administrator.dailynote.Home.Report.FragmentHomeReport;
import com.example.administrator.dailynote.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiuXiaocong on 7/28/2016.
 */
public class HomeActivity extends BaseActivity implements HomePresenter.HomeView {
    BottomBar mBottomBar;
    View mRoot;
    HomePresenter mHomePresenter;
    FragmentManager mFragmentManager;
    FragmentHomeNote mFragmentHomeNote;
    FragmentHomeHistory mFragmentHomeHistory;
    FragmentHomeReport mFragmentHomeReport;
    private int currentFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRoot = findViewById(R.id.root);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.note:
                        if (currentFragmentIndex != 0) {
                            replaceContent(mFragmentHomeNote);
                            currentFragmentIndex = 0;
                        }
                        Snackbar.make(mRoot, getResources().getString(R.string.tips_for_note), Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.history:
                        if (currentFragmentIndex != 1) {
                            replaceContent(mFragmentHomeHistory);
                            currentFragmentIndex = 1;
                        }
                        Snackbar.make(mRoot, getResources().getString(R.string.tips_for_history), Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.report:
                        if (currentFragmentIndex != 2) {
                            replaceContent(mFragmentHomeReport);
                            currentFragmentIndex = 2;
                        }
                        Snackbar.make(mRoot, getResources().getString(R.string.tips_for_report), Snackbar.LENGTH_LONG).show();
                        break;
                }
            }
        });
        mBottomBar.setActiveTabColor("#ff0000");
        mBottomBar.useDarkTheme(false);
        mBottomBar.setDefaultTabPosition(0);
        mHomePresenter = new HomePresenterImpl(this);
        mFragmentManager = getFragmentManager();
        mFragmentHomeNote = new FragmentHomeNote();
        mFragmentHomeHistory = new FragmentHomeHistory();
        mFragmentHomeReport = new FragmentHomeReport();
        replaceContent(mFragmentHomeNote);
    }

    private void replaceContent(Fragment fragment) {
        if (fragment != null) {
            mFragmentManager.beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHomePresenter.resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHomePresenter.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHomePresenter.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
