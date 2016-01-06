package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;

public class TilePieceView extends View {

    private TilePiece tilePiece;

    public TilePieceView(Context context) {
        super(context);
        this.tilePiece = null;
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
                this.tilePiece.getColor(),
                0
        ));

        // Draw the tile.
        canvas.drawRect(tileRect, tilePaint);
    }

    public void setTilePiece(TilePiece tilePiece) {
        this.tilePiece = tilePiece;
    }
}
