package com.example.dzhu_intrepid.tiletilerevolution.presenters;

import com.example.dzhu_intrepid.tiletilerevolution.models.TileBoard;
import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;
import com.example.dzhu_intrepid.tiletilerevolution.views.GameActivity;

import java.util.List;

public class TileBoardPresenter {

    private GameActivity gameActivity;
    private TileBoard tileBoard;

    public TileBoardPresenter(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
        this.tileBoard = new TileBoard(3);
    }

    public void onCreate() {
        // Load local image and convert into byte arrays.
        this.gameActivity.buildGrid(this.tileBoard.getDimension());
        this.gameActivity.constructImages("doge.jpg", this.tileBoard.getDimension());
    }

    public void onImageLoaded(byte[] originalImage, byte[][] tiledImages) {
        this.tileBoard.setImage(originalImage);
        this.tileBoard.setTileImages(tiledImages);
        this.gameActivity.updateBoard();
    }

    public void onTileClicked(int position) {
        this.tileBoard.moveTileToEmptySpace(position);
        this.gameActivity.updateBoard();
    }

    public List<TilePiece> getTilePiecesGrid() {
        return this.tileBoard.getTilePiecesGrid();
    }

    public int getBoardDimension() {
        return this.tileBoard.getDimension();
    }
}
