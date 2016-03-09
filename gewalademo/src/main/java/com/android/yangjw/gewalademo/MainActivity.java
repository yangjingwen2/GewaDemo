package com.android.yangjw.gewalademo;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.yangjw.gewalademo.fragment.FilmFragment;
import com.android.yangjw.gewalademo.fragment.HomeFragment;
import com.android.yangjw.gewalademo.utils.TransitionHelper;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private CompoundButton mCurrentCompoundButton;
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;
    private List<Fragment> fragments = new ArrayList<>();

    @ViewInject(R.id.home_menu_group)
    private RadioGroup mHomeMenuGroup;

    @ViewInject(R.id.home_search_bar_iv)
    private ImageView mSearchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RadioButton radioHomtButton = (RadioButton) mHomeMenuGroup.getChildAt(0);
        radioHomtButton.setChecked(true);
        setupFragment();
        showFragment(fragments.get(0));
    }

    @Event(value = R.id.home_menu_group,
            type = RadioGroup.OnCheckedChangeListener.class)
    private void onCheckedChangedListener(RadioGroup group, int checkedId) {

        int index = 0;
        RadioButton radioButton = (RadioButton) findViewById(checkedId);
        int resId = R.string.home_menu_home;
        switch (checkedId) {
            case R.id.home_menu_home:
                resId = R.string.home_menu_home;
                index = 0;
                break;
            case R.id.home_menu_film:
                index = 1;
                break;
            case R.id.home_menu_activity:
                resId = R.string.home_menu_activity;
                index = 2;
                break;
            case R.id.home_menu_movie:
                resId = R.string.home_menu_movie;
                index = 3;
                break;
            case R.id.home_menu_user:
                index = 4;
                resId = R.string.home_menu_user;
                break;
        }


        if (mCurrentCompoundButton != null) {
            mCurrentCompoundButton.setText("");
        }
        radioButton.setText(resId);

        mCurrentCompoundButton = radioButton;

        if (index < fragments.size())
        showFragment(fragments.get(index));
    }

    @Event(R.id.home_search_bar_layout)
    private void searchClick(View view) {
        Intent intent = new Intent(this,SearchActivity.class);
        Pair<View,String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true, new Pair(mSearchImageView, getString(R.string.home_search_transition_name)));
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,pairs);
        startActivity(intent,activityOptionsCompat.toBundle());

    }

    private void setupFragment() {
        mFragmentManager = getSupportFragmentManager();
        fragments.add(new HomeFragment());
        fragments.add(new FilmFragment());
        fragments.add(new FilmFragment());
        fragments.add(new FilmFragment());
        fragments.add(new FilmFragment());
    }

    private void showFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (mCurrentFragment != null) {
            fragmentTransaction.hide(mCurrentFragment);
        }
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.home_content,fragment);
        }
        fragmentTransaction.commit();

        mCurrentFragment = fragment;
    }
}
