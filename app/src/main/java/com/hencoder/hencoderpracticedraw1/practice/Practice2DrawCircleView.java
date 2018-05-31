package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;

    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.FILL);


        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.BLACK);


        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(Color.BLUE);

        paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setColor(Color.BLACK);
        paint4.setStrokeWidth(20);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

       canvas.drawCircle(180,100,100,paint1);

       canvas.drawCircle(540,100,100,paint2);

       canvas.drawLine(0,200,720,200,new Paint());

       canvas.drawCircle(180,300,100,paint3);

       canvas.drawCircle(540,300,100,paint4);


    }
}
