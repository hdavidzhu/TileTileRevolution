package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import android.view.View;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;

public class TileBoardPresenter {

    private int boardSize; // TODO: Get this information from the model.
    private TileBoard tileBoard;

    public TileBoardPresenter() {
        this.boardSize = 5;
    }

    public void clickTile(View view, int position, long id) {

    }

    public int getBoardSize() {
        return boardSize;
    }

    public TileBoard getTileBoard() {
        return tileBoard;
    }
}
