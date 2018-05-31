package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Practice10HistogramView extends View {

    private Paint paint1;
    private Paint paint2;
    private Path path;
    private int itemWidth;
    private int itemCounts;
    private ArrayList<Item> items;
    private int itemSpan;
    private Paint paint3;
    private int totalWidth;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.WHITE);
        paint1.setStyle(Paint.Style.STROKE);

        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(Color.BLUE);

        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3.setColor(Color.WHITE);
        paint3.setTextSize(18);
        paint3.setTextAlign(Paint.Align.CENTER);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        totalWidth = MeasureSpec.getSize(widthMeasureSpec);
        System.out.println("=========onMeasure==============="+totalWidth);
        path = new Path();
        path.moveTo(100, 0);
        path.lineTo(100, 300);
        path.lineTo(totalWidth-100, 300);

        itemWidth = 80;
        itemCounts = 3;
        items = new ArrayList<>();
        itemSpan = (int) ((float) (totalWidth-200 - itemWidth * itemCounts) / (itemCounts + 1));

        items.add(new Item("item1", 50, 100+itemSpan + itemWidth / 2));
        items.add(new Item("item2", 80, 100+itemSpan + itemWidth / 2 + itemSpan + itemWidth));
        items.add(new Item("item3", 200, 100+itemSpan * 3 + itemWidth / 2 * 5));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("=========onDraw==============="+totalWidth);


//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图


        canvas.drawPath(path, paint1);//100 - 520     420

        for (int i = 0; i < items.size(); i++) {
            canvas.drawRect(items.get(i).pos-itemWidth/2,300-items.get(i).height,
                    items.get(i).pos+itemWidth/2,300,paint2);
            canvas.drawText(items.get(i).name,items.get(i).pos,300+paint3.descent()-paint3.ascent(),paint3);
        }

        int item0Height = items.get(0).height;
        for (int i = 0; i < items.size(); i++) {
            if(i==items.size()-1){
                items.get(i).height=item0Height;
            }else {
                items.get(i).height= items.get(i+1).height;
            }
        }
        postInvalidateDelayed(1000);
    }


    class Item {
        Item(String name, int height, int pos) {
            this.name = name;
            this.height = height;
            this.pos = pos;
        }

        public String name;
        public int height;
        public int pos;
    }
}
