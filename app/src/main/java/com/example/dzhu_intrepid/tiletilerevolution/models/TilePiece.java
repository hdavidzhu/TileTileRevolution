package com.example.dzhu_intrepid.tiletilerevolution.models;

public class TilePiece {
    private Boolean empty;
    private int color;
    private byte[] image;

    public TilePiece() {
        this.empty = false;
        this.color = (int) Math.floor(Math.random() * 255);
    }

    public void markEmpty() {
        this.empty = true;
        this.color = 0;
    }

    public Boolean isEmpty() {
        return this.empty;
    }

    public int getColor() {
        return this.color;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
