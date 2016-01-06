package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TileBoard {

    private TilePiece[] tilePiecesGrid;
    private int dimension;
    // TODO: Add reference to image here as well.

    public TileBoard(int dimension) {
        this.dimension = dimension;
        this.tilePiecesGrid = new TilePiece[dimension * dimension - 1];
        this.generateTilePiecesGrid(this.dimension);
    }

    public TilePiece[] getTilePiecesGrid() {
        return this.tilePiecesGrid;
    }

    public TilePiece[] generateTilePiecesGrid(int size) {

        for (int i = 0; i < this.tilePiecesGrid.length; i++) {
            // TODO: Modify the tilePieces to contain the right chunk of image.
            this.tilePiecesGrid[i] = new TilePiece();
        }

        // Set the piece to be empty.
        TilePiece lastTilePiece = this.tilePiecesGrid[this.tilePiecesGrid.length - 1];
        lastTilePiece.markEmpty();

        return this.tilePiecesGrid;
    }

    public int getDimension() {
        return this.dimension;
    }
}
