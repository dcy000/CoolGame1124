package com.dcy.coolgame.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dcy.coolgame.R;

/**
 * Created by dcy123 on 2015/11/24.
 */
public class DrawGameView extends View{
    private Bitmap originalBitmap;
    private Bitmap newBitmap;
    private Paint mPaint = null;
    private Path mPath;
    private int color = Color.RED;
    private float strokeWidth = 20f;
    private float startX = 0;
    private float startY = 0;
    private float clickX = 0;
    private float clickY = 0;
    private boolean isMove = true;
    private boolean isClear = false;
    private Rect rect;

    public DrawGameView(Context context) {
        this(context, null);
    }

    public DrawGameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawGameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        originalBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)
                .copy(Bitmap.Config.ARGB_8888, true);
        newBitmap = originalBitmap.createBitmap(originalBitmap);
        mPath = new Path();
        initPaint();
    }

    public void setPaintColor(int color){
        mPaint.setColor(color);
    }

    public void clear(){
        isClear = true;
        mPath.reset();
        invalidate();
    }

    public Bitmap getBitmap(){
//        return newBitmap;
        setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(getDrawingCache());
        setDrawingCacheEnabled(false);
        return bitmap;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        rect = new Rect(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if(isClear){//清画布的2种方法
////            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
////            canvas.drawPaint(mPaint);
////            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//
////            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//            isClear = false;
//        } else {//可以在画布上画图片，然后返回图片
////            Canvas mCanvas = new Canvas(newBitmap);
////            mCanvas.drawPath(mPath, mPaint);
////            canvas.drawBitmap(newBitmap, null, rect, null);
//            canvas.drawPath(mPath, mPaint);
//        }
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        clickX = event.getX();
        clickY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = clickX;
                startY = clickY;
//                mPath.reset();
                mPath.moveTo(clickX, clickY);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.quadTo(startX, startY, (clickX + startX)/2, (clickY + startY)/2);
                startX = clickX;
                startY = clickY;
                invalidate();
                break;
        }
        return true;
    }

    private void initPaint(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        mPaint.setStrokeWidth(strokeWidth);
    }
}
