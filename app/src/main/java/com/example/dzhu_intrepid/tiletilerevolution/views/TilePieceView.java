package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class TilePieceView extends View {

    private int tileColor;

    public TilePieceView(Context context) {
        super(context);
        this.tileColor = 0;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int padding = 3;

        // Create the rectangle.
        Rect tileRect = new Rect(
                padding,    // Left.
                padding,    // Top.
                this.getWidth() - padding,  // Right.
                this.getHeight() - padding  // Bottom.
        );

        // Create the paint.
        Paint tilePaint = new Paint();
        tilePaint.setColor(Color.rgb(
                0,
                this.tileColor,
                0
        ));

        // Draw the tile.
        canvas.drawRect(tileRect, tilePaint);
    }

    public void setTileColor(int color) {
        this.tileColor = color;
    }
}
