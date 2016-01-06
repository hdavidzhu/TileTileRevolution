package com.example.dzhu_intrepid.tiletilerevolution.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public Object getItem(int position) {
        return null;
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
        } else {
            tilePieceView = (TilePieceView) convertView;
        }

        return tilePieceView;
    }
}
