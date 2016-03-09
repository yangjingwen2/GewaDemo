package com.android.yangjw.gewalademo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import junit.runner.Version;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * search
 */
@ContentView(R.layout.activity_search)
public class SearchActivity extends BaseActivity {

    @ViewInject(R.id.search_toolbar)
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEnterTransition();
        setupExitTransition();
    }

    private void setupEnterTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.search_transition);
            getWindow().setSharedElementEnterTransition(transition);
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        transition.removeListener(this);
                        int width = mToolBar.getWidth();
                        Animator animator = ViewAnimationUtils.createCircularReveal(mToolBar, 10, 20, 0, width);
                        mToolBar.setVisibility(View.VISIBLE);
                        animator.setDuration(500);
//                        animator.setInterpolator(new LinearInterpolator());
                        animator.start();
                    }
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        }
    }

    private void setupExitTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade returnTransition = new Fade();
            getWindow().setExitTransition(returnTransition);
            returnTransition.setDuration(1000);
            returnTransition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    transition.removeListener(this);
//                        int width = mToolBar.getWidth();
//                        Animator animator = ViewAnimationUtils.createCircularReveal(mToolBar, width, 0, 0, width);
//                        animator.addListener(new AnimatorListenerAdapter() {
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//                                super.onAnimationEnd(animation);
//                                mToolBar.setVisibility(View.INVISIBLE);
//                            }
//                        });
//                        animator.setDuration(1000);
////                        animator.setInterpolator(new LinearInterpolator());
//                        animator.start();
                    }
                }

                @Override
                public void onTransitionEnd(Transition transition) {

                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });

        }
    }
}
