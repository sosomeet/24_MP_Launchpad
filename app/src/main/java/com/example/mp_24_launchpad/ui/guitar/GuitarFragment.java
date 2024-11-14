package com.example.mp_24_launchpad.ui.guitar;

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
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentGuitarBinding;

public class GuitarFragment extends Fragment {

    private FragmentGuitarBinding binding;
    AppCompatButton guitar_btn_arr[][] = new AppCompatButton[4][4];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GuitarViewModel guitarViewModel =
                new ViewModelProvider(this).get(GuitarViewModel.class);

        binding = FragmentGuitarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.guitarGl;

        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4; j++){
                String buttonId = "guitar_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                guitar_btn_arr[i][j] = root.findViewById(resId);
            }
        }

        guitar_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "00", Toast.LENGTH_SHORT).show();
                guitar_btn_arr[0][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));
            }
        });

        guitar_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        guitar_btn_arr[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        guitar_btn_arr[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        guitar_btn_arr[3][3].setOnClickListener(new View.OnClickListener() {
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