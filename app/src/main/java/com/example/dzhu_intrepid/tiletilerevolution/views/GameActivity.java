package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dzhu_intrepid.tiletilerevolution.R;
import com.example.dzhu_intrepid.tiletilerevolution.views.adapters.TileBoardAdapter;
import com.example.dzhu_intrepid.tiletilerevolution.helpers.ImageHelper;
import com.example.dzhu_intrepid.tiletilerevolution.presenters.TileBoardPresenter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import timber.log.Timber;

public class GameActivity extends AppCompatActivity {

    public TileBoardPresenter tileBoardPresenter;
    private RecyclerView tileBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.tileBoardPresenter = new TileBoardPresenter(this);
        this.tileBoardPresenter.onCreate();
    }

    public void constructImages(String fileName, final int boardDimension) {
        Picasso.with(this).load("file:///android_asset/" + fileName).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap originalImage, Picasso.LoadedFrom from) {
                Bitmap[] tiledImages = ImageHelper.splitBitmap(originalImage, boardDimension);
                byte[] originalSerializedImage = ImageHelper.serializeImage(originalImage);
                byte[][] tiledSerialziedImages = ImageHelper.serializeImages(tiledImages);
                GameActivity.this.tileBoardPresenter.onImageLoaded(originalSerializedImage, tiledSerialziedImages);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Timber.d("Image loading failed.");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Timber.d("Image load preparing.");
            }
        });
    }

    public void buildGrid(int boardDimension) {
        this.tileBoardView = (RecyclerView) findViewById(R.id.tile_board_view);
        this.tileBoardView.setLayoutManager(new GridLayoutManager(this, boardDimension));
        this.tileBoardView.setAdapter(new TileBoardAdapter(this, this.tileBoardPresenter));
    }

    public void updateBoard() {
        ((TileBoardAdapter) tileBoardView.getAdapter()).notifyDataSetChanged();
    }
}
