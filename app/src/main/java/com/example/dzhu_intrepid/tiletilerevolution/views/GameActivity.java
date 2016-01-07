package com.example.dzhu_intrepid.tiletilerevolution.views;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.dzhu_intrepid.tiletilerevolution.R;
import com.example.dzhu_intrepid.tiletilerevolution.adapters.TileBoardAdapter;
import com.example.dzhu_intrepid.tiletilerevolution.presenters.TileBoardPresenter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GameActivity extends AppCompatActivity {

    public TileBoardPresenter tileBoardPresenter;
    private GridView tileBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.tileBoardPresenter = new TileBoardPresenter(this);

        Bitmap originalImage = this.loadImage();
        Bitmap[] tiledImages = this.splitBitmap(originalImage, tileBoardPresenter.getBoardDimension());
        this.tileBoardPresenter.applyImagesToTileBoard(originalImage, tiledImages);

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

    public Bitmap loadImage() {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputImageStream = assetManager.open("doge.jpg");
            Bitmap image = BitmapFactory.decodeStream(inputImageStream);
            inputImageStream.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bitmap[] splitBitmap(Bitmap originalBitmap, int dimension) {
        if (originalBitmap == null) {
            return null;
        }

        int width = originalBitmap.getWidth() / dimension;
        int height = originalBitmap.getHeight() / dimension;
        Bitmap[] bitmapHolder = new Bitmap[dimension * dimension];

        for (int yIndex = 0; yIndex < dimension; yIndex++) {
            for (int xIndex = 0; xIndex < dimension; xIndex++) {
                bitmapHolder[xIndex * dimension + yIndex] = Bitmap.createBitmap(
                        originalBitmap, width * xIndex, height * yIndex, width, height);
            }
        }

        return bitmapHolder;
    }

    public void updateBoard() {
        ((TileBoardAdapter) tileBoardView.getAdapter()).notifyDataSetChanged();
    }

    // TODO: Not sure if these methods belong here.
    public byte[] serializeImage(Bitmap bitmapImage) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public Bitmap deserializeImage(byte[] byteImage) {
        return BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }
}
