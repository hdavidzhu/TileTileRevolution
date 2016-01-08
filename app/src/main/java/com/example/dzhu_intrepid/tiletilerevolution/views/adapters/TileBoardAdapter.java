package com.example.dzhu_intrepid.tiletilerevolution.views.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dzhu_intrepid.tiletilerevolution.helpers.ImageHelper;
import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;
import com.example.dzhu_intrepid.tiletilerevolution.presenters.TileBoardPresenter;
import com.example.dzhu_intrepid.tiletilerevolution.views.TilePieceView;

public class TileBoardAdapter extends RecyclerView.Adapter<TileBoardAdapter.TilePieceViewHolder> {

    private Context context;
    private TileBoardPresenter tileBoardPresenter;

    public TileBoardAdapter(Context context, TileBoardPresenter tileBoardPresenter) {
        this.context = context;
        this.tileBoardPresenter = tileBoardPresenter;
    }

    @Override
    public TilePieceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TilePieceView tilePieceView = new TilePieceView(parent.getContext());
        return new TilePieceViewHolder(tilePieceView, tileBoardPresenter);
    }

    @Override
    public void onBindViewHolder(TilePieceViewHolder holder, int position) {
        // TODO: This is becoming highly coupled.
        TilePiece tilePiece = this.tileBoardPresenter.getTilePiecesGrid().get(position);

        Bitmap tileImage = null;
        if (tilePiece.getImage() != null) {
            tileImage = ImageHelper.deserializeImage(tilePiece.getImage());
        }
        holder.bindTilePiece(tilePiece, tileImage);
    }

    @Override
    public int getItemCount() {
        int boardSize = this.tileBoardPresenter.getBoardDimension();
        return  boardSize * boardSize;
    }

    static class TilePieceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TileBoardPresenter tileBoardPresenter;

        public TilePieceViewHolder(View tilePieceView, TileBoardPresenter tileBoardPresenter) {
            super(tilePieceView);
            this.tileBoardPresenter = tileBoardPresenter;
            tilePieceView.setOnClickListener(this);
        }

        public void bindTilePiece(TilePiece tilePiece, Bitmap tileImage) {
            // TODO: Set to the right view in the declaration.
            ((TilePieceView) this.itemView).setTilePiece(tilePiece);
            ((TilePieceView) this.itemView).setTileImage(tileImage);
        }

        @Override
        public void onClick(View v) {
            this.tileBoardPresenter.onTileClicked(getLayoutPosition());
        }
    }
}

