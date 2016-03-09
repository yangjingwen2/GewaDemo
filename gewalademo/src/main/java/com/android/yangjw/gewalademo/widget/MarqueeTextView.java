package com.android.yangjw.gewalademo.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by yangjw on 2016/2/22.
 */
public class MarqueeTextView extends TextView{
    public MarqueeTextView(Context context) {
        super(context);
        initView();
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
        setFocusableInTouchMode(true);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused)
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus)
        super.onWindowFocusChanged(hasWindowFocus);
    }
}
