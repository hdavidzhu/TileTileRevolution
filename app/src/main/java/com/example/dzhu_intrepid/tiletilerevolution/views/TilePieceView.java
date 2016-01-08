package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;

public class TilePieceView extends View {

    private TilePiece tilePiece;
    private Bitmap tileImage;

    public TilePieceView(Context context) {
        super(context);
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

        // Create the paint.
        Paint tilePaint = new Paint();
        tilePaint.setColor(Color.rgb(
                0,
                this.tilePiece.getColor(),
                0
        ));

        if (this.tileImage == null) {
            // Create the rectangle.
            Rect tileRect = new Rect(
                    padding,    // Left.
                    padding,    // Top.
                    this.getWidth() - padding,  // Right.
                    this.getHeight() - padding  // Bottom.
            );

            // Draw the tile.
            canvas.drawRect(tileRect, tilePaint);
        } else {
            if (!this.tilePiece.isEmpty()) {
                canvas.drawBitmap(this.tileImage, (float) padding, (float) padding, tilePaint);
            }
        }
    }

    public void setTilePiece(TilePiece tilePiece) {
        this.tilePiece = tilePiece;
    }
    
    public void setTileImage(Bitmap tileImage) {
        this.tileImage = tileImage;
    }
}
