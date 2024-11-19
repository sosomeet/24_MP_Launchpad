package com.example.mp_24_launchpad.ui.guitar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.SoundPool;
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

import com.example.mp_24_launchpad.R;
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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonId = "guitar_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                guitar_btn_arr[i][j] = root.findViewById(resId);
            }
        }

        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(16).build();
        // bring the guitar resources id from R.raw
        int[][] guitar_sound_id = {
                {R.raw.tmp_00, R.raw.tmp_01, R.raw.tmp_02, R.raw.tmp_03},
                {R.raw.tmp_10, R.raw.tmp_11, R.raw.tmp_00, R.raw.tmp_01},
                {R.raw.tmp_02, R.raw.tmp_03, R.raw.tmp_10, R.raw.tmp_11},
                {R.raw.tmp_00, R.raw.tmp_01, R.raw.tmp_02, R.raw.tmp_03}
        };
        // set the guitar resources for use soundPool
        int[][] guitar_soundpool = {
                {soundPool.load(getContext(), guitar_sound_id[0][0], 1),
                        soundPool.load(getContext(), guitar_sound_id[0][1], 1),
                        soundPool.load(getContext(), guitar_sound_id[0][2], 1),
                        soundPool.load(getContext(), guitar_sound_id[0][3], 1)},
                {soundPool.load(getContext(), guitar_sound_id[1][0], 1),
                        soundPool.load(getContext(), guitar_sound_id[1][1], 1),
                        soundPool.load(getContext(), guitar_sound_id[1][2], 1),
                        soundPool.load(getContext(), guitar_sound_id[1][3], 1)},
                {soundPool.load(getContext(), guitar_sound_id[2][0], 1),
                        soundPool.load(getContext(), guitar_sound_id[2][1], 1),
                        soundPool.load(getContext(), guitar_sound_id[2][2], 1),
                        soundPool.load(getContext(), guitar_sound_id[2][3], 1)},
                {soundPool.load(getContext(), guitar_sound_id[3][0], 1),
                        soundPool.load(getContext(), guitar_sound_id[3][1], 1),
                        soundPool.load(getContext(), guitar_sound_id[3][2], 1),
                        soundPool.load(getContext(), guitar_sound_id[3][3], 1)}
        };

        guitar_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sound priority is higher than change color
                soundPool.play(guitar_soundpool[0][0], 1.0f, 1.0f, 1, 0, 1.0f);

                // if sound is called, button color change
                guitar_btn_arr[0][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));
            }
        });

        guitar_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[0][1], 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });

        guitar_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[0][2], 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });

        guitar_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[0][3], 1.0f, 1.0f, 1, 0, 1.0f);


            }
        });

        guitar_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[1][0], 1.0f, 1.0f, 1, 0, 1.0f);

            }
        });

        guitar_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[1][1], 1.0f, 1.0f, 1, 0, 1.0f);

            }
        });

        guitar_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(guitar_soundpool[0][0], 1.0f, 1.0f, 1, 0, 1.0f);

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