package com.lxj.ripplelayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by lxj on 2016/8/4.
 */
public class RippleLayout extends FrameLayout {

    private int internal = 2000;//时间间隔
    private int endRadius;
    int RippleColor = Color.parseColor("#FF0000");

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startRipple();
        }
    };

    public RippleLayout(Context context) {
        super(context);
        init();
    }

    public RippleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RippleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        endRadius = windowManager.getDefaultDisplay().getWidth();
    }

    public void setRippleInternal(int internal) {
        this.internal = internal;
    }

    public void setEndRadius(int endRadius) {
        this.endRadius = endRadius;
    }

    public void setRippleColor(int RippleColor) {
        this.RippleColor = RippleColor;
    }

    public void startRipple() {
        addRippleView();
        handler.sendEmptyMessageDelayed(0, internal);
    }

    private Point center;

    public void setRippleCenter(int x,int y) {
        this.center = new Point(x,y);
    }

    private void addRippleView() {
        RippleView rippleView = new RippleView(getContext());
        rippleView.setRadiusRange(0, endRadius);
        if (center != null) {
            rippleView.setRippleCenter(center);
        }
        rippleView.setRippleColor(RippleColor);

        rippleView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        rippleView.getViewTreeObserver().addOnGlobalLayoutListener(new OnRippleViewLayoutListener(rippleView));
        addView(rippleView);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacksAndMessages(null);
    }
}
