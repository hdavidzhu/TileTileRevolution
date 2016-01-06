package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TilePiece {
    private Boolean empty;

    public TilePiece() {
        this.empty = false;
    }

    public void markEmpty() {
        this.empty = true;
    }

    public void markFilled() {
        this.empty = false;
    }

    public Boolean isEmpty() {
        return this.empty;
    }
}
