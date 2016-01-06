package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TilePiece {
    private Boolean isEmpty;

    public TilePiece() {
        this.isEmpty = false;
    }

    public void markEmpty() {
        this.isEmpty = true;
    }

    public void markFilled() {
        this.isEmpty = false;
    }
}
