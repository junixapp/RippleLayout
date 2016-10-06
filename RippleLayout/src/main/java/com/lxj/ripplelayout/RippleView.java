package com.lxj.ripplelayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by lxj on 2016/8/1.
 */
public class RippleView extends View {

    private Paint paint;
    private int color = Color.parseColor("#FF0000");
    private int startRadius = 0;//起始的时候的半径
    private int endRadius = 0;//结束时候的半径
    private int radius = startRadius;//当前的半径
    private Point center;//圆心
    long duration = 6000;
    ValueAnimator animator;


    public RippleView(Context context) {
        super(context);
        init();
    }

    public RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RippleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
    }

    public void setRippleColor(int color) {
        this.color = color;
        paint.setColor(color);
    }

    public void setRadiusRange(int startRadius, int endRadius) {
        this.startRadius = startRadius;
        this.endRadius = endRadius;
    }

    public long getDuration(){
        return  duration;
    }

    public void setRippleCenter(Point center) {
        this.center = center;
    }

    public void setDuration(long duration){
        this.duration = duration;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(endRadius==0){
            endRadius = (int) Math.sqrt(Math.pow(getMeasuredWidth(), 2) + Math.pow(getMeasuredHeight(), 2));
        }
        if(center==null){
            center = new Point(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        }

        canvas.drawCircle(center.x, center.y, radius, paint);
    }


    /**
     * 开始执行水波纹动画
     */
    public void rippleAnim(){
        if (animator == null) {
            animator = ValueAnimator.ofInt(startRadius, endRadius);
            animator.setInterpolator(new LinearInterpolator());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    radius = (int) animation.getAnimatedValue();
                    setAlpha(1-animation.getAnimatedFraction());

                    invalidate();
                }
            });
            animator.setDuration(duration);
        }
        animator.start();
    }



    public void stopRipple() {
        animator.cancel();
    }

}
