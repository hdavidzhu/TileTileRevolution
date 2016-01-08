package com.example.dzhu_intrepid.tiletilerevolution.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;
import com.example.dzhu_intrepid.tiletilerevolution.presenters.TileBoardPresenter;
import com.example.dzhu_intrepid.tiletilerevolution.views.TilePieceView;

import java.util.List;

public class TileBoardAdapter extends RecyclerView.Adapter<TilePieceViewHolder> {

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
        List<TilePiece> tilePieceList = this.tileBoardPresenter.getTilePiecesGrid();
        holder.bindTilePiece(tilePieceList.get(position));
    }

    @Override
    public int getItemCount() {
        int boardSize = this.tileBoardPresenter.getBoardDimension();
        return  boardSize * boardSize;
    }
}

class TilePieceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TileBoardPresenter tileBoardPresenter;

    public TilePieceViewHolder(View tilePieceView, TileBoardPresenter tileBoardPresenter) {
        super(tilePieceView);
        this.tileBoardPresenter = tileBoardPresenter;
        tilePieceView.setOnClickListener(this);
    }

    public void bindTilePiece(TilePiece tilePiece) {
        ((TilePieceView) this.itemView).setTilePiece(tilePiece);
    }

    @Override
    public void onClick(View v) {
        int position = getLayoutPosition();
        this.tileBoardPresenter.onTileClicked(position);
    }
}
