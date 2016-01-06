package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import android.view.View;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;

public class TileBoardPresenter {

    private int boardSize = 5; // TODO: Get this information from the model.
    private TileBoard tileBoard;

    public int getBoardSize() {
        return boardSize;
    }

    public TileBoard getTileBoard() {
        return tileBoard;
    }

    public void clickTile(View view, int position, long id) {

    }
}
