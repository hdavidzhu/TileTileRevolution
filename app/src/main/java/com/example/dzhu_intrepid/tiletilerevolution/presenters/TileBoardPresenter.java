package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;
import com.example.dzhu_intrepid.tiletilerevolution.views.GameActivity;

public class TileBoardPresenter {

    private GameActivity gameActivity;
    private TileBoard tileBoard;

    public TileBoardPresenter(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
        this.tileBoard = new TileBoard(3);
    }

    public void applyImagesToTileBoard(byte[] originalImage, byte[][] tiledImages) {
        this.tileBoard.setImage(originalImage);
        this.tileBoard.setTileImages(tiledImages);
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
