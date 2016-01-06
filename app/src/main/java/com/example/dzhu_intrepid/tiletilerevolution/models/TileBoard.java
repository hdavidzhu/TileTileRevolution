package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TileBoard {

    private TilePiece[] tilePiecesGrid;
    private int size;
    // TODO: Add reference to image here as well.

    public TileBoard(int size) {
        this.size = size;
        this.generateTilePiecesGrid(size);
    }

    public TilePiece[] getTilePiecesGrid() {
        return this.tilePiecesGrid;
    }

    public TilePiece[] generateTilePiecesGrid(int size) {

        for (int i = 0; i < size * size; i++) {
            // TODO: Modify the tilePieces to contain the right chunk of image.
            this.tilePiecesGrid[i] = new TilePiece();
        }

        return this.tilePiecesGrid;
    }
}
