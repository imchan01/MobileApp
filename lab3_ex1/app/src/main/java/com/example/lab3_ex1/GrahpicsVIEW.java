package com.example.lab3_ex1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GrahpicsVIEW extends View {
    public GrahpicsVIEW(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r = new Rect(40,40,400,200);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);;
        paint.setColor(Color.YELLOW);
        canvas.drawRect(r, paint);

        invalidate();
    }
}
