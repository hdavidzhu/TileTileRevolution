package com.example.dzhu_intrepid.tiletilerevolution;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GameBoardFragment extends Fragment {

    public static GameBoardFragment newInstance() {
        GameBoardFragment fragment = new GameBoardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_board, container, false);
    }
}
