package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by yangjw on 2016/2/21.
 */
public class LiwushuoHeaderAnimaLayout extends LoadingLayout{

    private AnimationDrawable animationDrawable;

    public LiwushuoHeaderAnimaLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        mHeaderImage.setImageResource(R.drawable.anima_liwushuo_header);
        animationDrawable = (AnimationDrawable) mHeaderImage.getDrawable();
    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.box_01;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    @Override
    protected void pullToRefreshImpl() {

    }

    @Override
    protected void refreshingImpl() {

        animationDrawable.start();
    }

    @Override
    protected void releaseToRefreshImpl() {

    }

    @Override
    protected void resetImpl() {
        mHeaderImage.clearAnimation();
        mHeaderImage.setVisibility(View.VISIBLE);
    }
}
