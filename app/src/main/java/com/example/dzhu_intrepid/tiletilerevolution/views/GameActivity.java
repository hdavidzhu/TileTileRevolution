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

    private GridView tileBoardView;
    private TileBoardPresenter tileBoardPresenter = new TileBoardPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.tileBoardView = (GridView) findViewById(R.id.tile_board_view);
        this.tileBoardView.setAdapter(new TileBoardAdapter(this));
        this.tileBoardView.setNumColumns(5);

        tileBoardView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tileBoardPresenter.clickTile(view, position, id);
            }
        });
    }
}
