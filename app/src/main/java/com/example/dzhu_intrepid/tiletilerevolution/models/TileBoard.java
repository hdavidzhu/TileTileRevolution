package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TileBoard {

    private TilePiece[][] tilePiecesGrid;
    private int size;

    public TileBoard(int size) {
        this.size = size;
        this.generateTilePiecesGrid(size);
    }

    public TilePiece[][] generateTilePiecesGrid(int size) {
        for (int i = 0; i < size; i++) {
            TilePiece[] tilePiecesRow = new TilePiece[size];
            for (int j = 0; j < size; j++) {
                tilePiecesRow[j] = new TilePiece();
            }
            this.tilePiecesGrid[i] = tilePiecesRow;
        }
        return this.tilePiecesGrid;
    }
}
