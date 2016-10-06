package com.lxj.ripplelayout;



import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


/**
 * Created by lxj on 2016/8/4.
 */
public class OnRippleViewLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
    private RippleView rippleView;

    public OnRippleViewLayoutListener(RippleView rippleView) {
        this.rippleView = rippleView;
    }
    @Override
    public void onGlobalLayout() {
        rippleView.getViewTreeObserver().removeGlobalOnLayoutListener(this);

        rippleView.rippleAnim();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(rippleView.getParent()!=null){
                    ViewGroup parent = (ViewGroup) rippleView.getParent();
                    parent.removeView(rippleView);
                    rippleView = null;
                }
            }
        }, rippleView.getDuration()+5);
    }
}
