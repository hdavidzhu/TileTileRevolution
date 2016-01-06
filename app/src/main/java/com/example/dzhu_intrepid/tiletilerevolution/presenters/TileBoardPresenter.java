package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import android.view.View;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;

public class TileBoardPresenter {

    private TileBoard tileBoard;

    public TileBoardPresenter() {
        this.tileBoard = new TileBoard(3);
    }

    public void clickTile(View view, int position, long id) {
        View myView = view;
        int myPosition = position;
        long myId = id;
    }

    public int getBoardDimension() {
        return this.tileBoard.getDimension();
    }

    public TileBoard getTileBoard() {
        return tileBoard;
    }
}
