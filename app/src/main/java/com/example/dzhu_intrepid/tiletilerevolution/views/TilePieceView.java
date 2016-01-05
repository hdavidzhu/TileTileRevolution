package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class TilePieceView extends View {

    private Rect tileRect;
    private Paint tilePaint;

    public TilePieceView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Create the rectangle.
        this.tileRect = new Rect(0,0,100,100);

        // Create the paint.
        this.tilePaint = new Paint();
        tilePaint.setColor(Color.rgb(255,0,0));

        // Draw the tile.
        canvas.drawRect(tileRect, tilePaint);
    }
}
