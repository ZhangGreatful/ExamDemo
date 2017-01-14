package com.haha.exam.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.haha.exam.R;
import com.haha.exam.ui.Fragment.HomeFragment;
import com.haha.exam.ui.Fragment.MineFragment;
import com.haha.exam.ui.Fragment.PracticeFragment;
import com.haha.exam.ui.Fragment.StudyFragment;
import com.haha.exam.view.TabStripView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.navigateTabBar)
    TabStripView tabStripView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        tabStripView.addTab(HomeFragment.class, new TabStripView.TabParam(R.drawable.study_grey, R.drawable.study_orange
                , "首页"));
        tabStripView.addTab(StudyFragment.class, new TabStripView.TabParam(R.drawable.study_grey, R.drawable.study_orange,
                "在线学习"));
        tabStripView.addTab(PracticeFragment.class, new TabStripView.TabParam(R.drawable.assessment_grey, R.drawable.assessment_orange,
                "自我测评"));
        tabStripView.addTab(MineFragment.class, new TabStripView.TabParam(R.drawable.mine_grey, R.drawable.mine_orange,
                "我的"));
    }
}
