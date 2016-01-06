package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dzhu_intrepid.tiletilerevolution.R;
import com.example.dzhu_intrepid.tiletilerevolution.adapters.TileBoardAdapter;
import com.example.dzhu_intrepid.tiletilerevolution.presenters.TileBoardPresenter;

public class GameActivity extends AppCompatActivity {

    public TileBoardPresenter tileBoardPresenter;
    private GridView tileBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.tileBoardPresenter = new TileBoardPresenter(this);

        this.tileBoardView = (GridView) findViewById(R.id.tile_board_view);
        this.tileBoardView.setAdapter(new TileBoardAdapter(this));
        this.tileBoardView.setNumColumns(tileBoardPresenter.getBoardDimension());

        tileBoardView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tileBoardPresenter.clickTile(position);
            }
        });
    }

    public void updateBoard() {
        ((TileBoardAdapter) tileBoardView.getAdapter()).notifyDataSetChanged();
    }
}
