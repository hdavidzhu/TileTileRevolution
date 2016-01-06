package com.example.dzhu_intrepid.tiletilerevolution.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dzhu_intrepid.tiletilerevolution.models.TilePiece;
import com.example.dzhu_intrepid.tiletilerevolution.views.GameActivity;
import com.example.dzhu_intrepid.tiletilerevolution.views.TilePieceView;

public class TileBoardAdapter extends BaseAdapter {

    private Context context;

    public TileBoardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        int boardSize = ((GameActivity) this.context).tileBoardPresenter.getBoardDimension();
        return  boardSize * boardSize;
    }

    @Override
    public TilePiece getItem(int position) {
        // TODO: Refactor to make a tilePiece easier to retrieve.
        return ((GameActivity) this.context).tileBoardPresenter
                .getTileBoard().getTilePiecesGrid().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TilePieceView tilePieceView;

        if (convertView == null) {
            tilePieceView = new TilePieceView(this.context);
            // TODO: Bind color correctly with the view.
            tilePieceView.setTileColor(this.getItem(position).getColor());
        } else {
            tilePieceView = (TilePieceView) convertView;
            tilePieceView.setTileColor(this.getItem(position).getColor());
        }

        return tilePieceView;
    }
}
