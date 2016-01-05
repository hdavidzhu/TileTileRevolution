package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class TileBoardView extends ViewGroup {

    public TileBoardView(Context context) {
        super(context);
    }

    public TileBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TileBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    //    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//
//        // Calculate the dimensions of our game board.
//        int currentWidth = right - left;
//        int currentHeight = bottom - top;
//        int minPixelDimension = Math.min(currentWidth, currentHeight);
//
//        // Grab the board information.
//        int boardSize = tileBoardPresenter.getBoardSize();
//        TileBoard board = tileBoardPresenter.getTileBoard();
//
//        for (int i = 0; i < boardSize; i++) {
//            for (int j = 0; j < boardSize; j++) {
//                TilePieceView tilePieceView = new TilePieceView(getContext());
//                this.addView(tilePieceView);
//            }
//
//        }
//    }
}