package com.example.dzhu_intrepid.tiletilerevolution.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dzhu_intrepid.tiletilerevolution.views.TilePieceView;

public class TileBoardAdapter extends BaseAdapter {

    private Context context;

    public TileBoardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Adapted from http://www.learn2crack.com/2014/01/android-custom-gridview.html
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TilePieceView tilePieceView;

        if (convertView == null) {
            tilePieceView = new TilePieceView(context);
        } else {
            tilePieceView = (TilePieceView) convertView;
        }

        return tilePieceView;
    }
}
