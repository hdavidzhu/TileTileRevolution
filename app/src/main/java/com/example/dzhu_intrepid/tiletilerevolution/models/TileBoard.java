package com.example.dzhu_intrepid.tiletilerevolution.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileBoard {

    private ArrayList<TilePiece> tilePiecesGrid;
    private int dimension;
    private byte[] image;

    public TileBoard(int dimension) {
        this.dimension = dimension;
        this.tilePiecesGrid = new ArrayList<TilePiece>();
        this.generateTilePiecesGrid();
    }

    public List<TilePiece> getTilePiecesGrid() {
        return this.tilePiecesGrid;
    }

    public ArrayList<TilePiece> generateTilePiecesGrid() {

        for (int i = 0; i < this.dimension * this.dimension; i++) {
            // TODO: Modify the tilePieces to contain the right chunk of image.
            tilePiecesGrid.add(new TilePiece());
        }

        // Set the piece to be empty.
        TilePiece lastTilePiece = this.tilePiecesGrid.get(this.tilePiecesGrid.size() - 1);
        lastTilePiece.markEmpty();

        return this.tilePiecesGrid;
    }

    public void moveTileToEmptySpace(int tilePosition) {
        int[] neighborPos = this.getViableNeighborPositions(tilePosition);
        int emptyTilePosition = this.getEmptyPiecePos(neighborPos);

        if (emptyTilePosition != -1) {
            Collections.swap(this.tilePiecesGrid, tilePosition, emptyTilePosition);
        }
    }

    public int[] getViableNeighborPositions(int chosenTilePosition) {

        int[] neighborPos = new int[4];

        // Determine the XY-coordinate.
        int horizonalLocation= chosenTilePosition % this.dimension;
        int verticalLocation = chosenTilePosition / this.dimension;

        // Check to see if on edges.
        Boolean isOnLeftEdge = horizonalLocation == 0;
        Boolean isOnRightEdge = horizonalLocation == this.dimension - 1;
        Boolean isOnTopEdge = verticalLocation == 0;
        Boolean isOnBottomEdge = verticalLocation == this.dimension - 1;

        // Provide references to which positions are available.
        // Set the reference to -1 if not possible.
        neighborPos[0] = !isOnLeftEdge ? chosenTilePosition - 1 : -1;                   // Left.
        neighborPos[1] = !isOnTopEdge ? chosenTilePosition - this.dimension : -1;       // Top.
        neighborPos[2] = !isOnRightEdge ? chosenTilePosition + 1 : -1;                  // Right.
        neighborPos[3] = !isOnBottomEdge ? chosenTilePosition + this.dimension : -1;    // Bottom.

        return neighborPos;
    }

    // Returns the empty TilePiece position if it exists in the array of tile positions.
    public int getEmptyPiecePos(int[] tilePositions) {
        for (int tilePosition : tilePositions) {
            if (tilePosition == -1) { continue; }
            if (tilePiecesGrid.get(tilePosition).isEmpty()) {
                return tilePosition;
            }
        }
        return -1;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setTileImages(byte[][] images) {
        for (int tileIndex = 0; tileIndex < this.tilePiecesGrid.size(); tileIndex++) {
            TilePiece chosenTile = this.tilePiecesGrid.get(tileIndex);
            chosenTile.setImage(image);
        }
    }
}
