package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import android.graphics.Bitmap;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;
import com.example.dzhu_intrepid.tiletilerevolution.views.GameActivity;

public class TileBoardPresenter {

    private GameActivity gameActivity;
    private TileBoard tileBoard;

    public TileBoardPresenter(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
        this.tileBoard = new TileBoard(3);
    }

    public void applyImagesToTileBoard(Bitmap originalImage, Bitmap[] tiledImages) {
        // this.tileBoard.setImage();
        // this.tileBoard.setTileImages();
    }

    public void clickTile(int position) {
        this.tileBoard.moveTileToEmptySpace(position);
        this.gameActivity.updateBoard();
    }

    public int getBoardDimension() {
        return this.tileBoard.getDimension();
    }

    public TileBoard getTileBoard() {
        return tileBoard;
    }
}
