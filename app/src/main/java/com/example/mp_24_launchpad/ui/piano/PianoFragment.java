package com.example.mp_24_launchpad.ui.piano;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentPianoBinding;

public class PianoFragment extends Fragment {

    private FragmentPianoBinding binding;
    AppCompatButton piano_btn_arr[][] = new AppCompatButton[4][4];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PianoViewModel pianoViewModel =
                new ViewModelProvider(this).get(PianoViewModel.class);

        binding = FragmentPianoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.pianoGl;

        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4; j++){
                String buttonId = "piano_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                piano_btn_arr[i][j] = root.findViewById(resId);
            }
        }

        piano_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "00", Toast.LENGTH_SHORT).show();
                piano_btn_arr[0][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));
            }
        });

        piano_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        piano_btn_arr[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        piano_btn_arr[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        piano_btn_arr[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}