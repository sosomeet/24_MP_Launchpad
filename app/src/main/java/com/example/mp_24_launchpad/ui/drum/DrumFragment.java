package com.example.mp_24_launchpad.ui.drum;

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
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentDrumBinding;

public class DrumFragment extends Fragment {

    private FragmentDrumBinding binding;
    AppCompatButton drum_btn_arr[][] = new AppCompatButton[4][4];

    //private SoundPool soundPool;
    private int soundDrum[] = new int[16];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DrumViewModel drumViewModel =
                new ViewModelProvider(this).get(DrumViewModel.class);

        binding = FragmentDrumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.drumGl;

        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4; j++){
                String buttonId = "drum_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                drum_btn_arr[i][j] = root.findViewById(resId);
            }
        }
        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(16).build();


        int[][] drum_sound_id= {

        };

        int[][] drum_soundpool = {
                {soundPool.load(getContext(), drum_sound_id[0][0], 1),
                        soundPool.load(getContext(), drum_sound_id[0][1], 1),
                        soundPool.load(getContext(), drum_sound_id[0][2], 1),
                        soundPool.load(getContext(), drum_sound_id[0][3], 1)},

                {soundPool.load(getContext(), drum_sound_id[1][0], 1),
                        soundPool.load(getContext(), drum_sound_id[1][1], 1),
                        soundPool.load(getContext(), drum_sound_id[1][2], 1),
                        soundPool.load(getContext(), drum_sound_id[1][3], 1)},

                {soundPool.load(getContext(), drum_sound_id[2][0], 1),
                        soundPool.load(getContext(), drum_sound_id[2][1], 1),
                        soundPool.load(getContext(), drum_sound_id[2][2], 1),
                        soundPool.load(getContext(), drum_sound_id[2][3], 1)},

                {soundPool.load(getContext(), drum_sound_id[3][0], 1),
                        soundPool.load(getContext(), drum_sound_id[3][1], 1),
                        soundPool.load(getContext(), drum_sound_id[3][2], 1),
                        soundPool.load(getContext(), drum_sound_id[3][3], 1)}
        };


        // crash cymbal
        drum_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[0][0], 1.0f,1.0f,1,0,1.0f);

                drum_btn_arr[0][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));
            }
        });
        // Tom(high)
        drum_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[0][1], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[0][1].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));
            }
        });

        // Tom(mid)
        drum_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[0][2], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[0][2].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // Tom (low)
        drum_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[0][3], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[0][3].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // Ride Cymbal
        drum_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[1][0], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[1][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // Shaker
        drum_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[1][1], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[1][1].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // cowbell
        drum_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[1][2], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[1][2].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // High Hat(closed)
        drum_btn_arr[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[1][3], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[1][3].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // splash cymbal
        drum_btn_arr[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[2][0], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[2][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        //snare
        drum_btn_arr[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[2][1], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[2][1].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        //tambourine
        drum_btn_arr[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[2][2], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[2][2].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // high hat (opened)
        drum_btn_arr[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[2][3], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[2][3].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // kick
        drum_btn_arr[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[3][0], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[3][0].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        //reverse symbal
        drum_btn_arr[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[3][1], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[3][1].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // clap
        drum_btn_arr[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[3][2], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[3][2].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

            }
        });

        // rim shot
        drum_btn_arr[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(drum_soundpool[3][3], 1.0f,1.0f,1,0,1.0f);
                drum_btn_arr[3][3].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DD0000")));

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