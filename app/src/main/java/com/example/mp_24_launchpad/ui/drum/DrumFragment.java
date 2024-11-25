package com.example.mp_24_launchpad.ui.drum;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.example.mp_24_launchpad.databinding.FragmentDrumBinding;


public class DrumFragment extends Fragment {

    private FragmentDrumBinding binding;
    AppCompatButton drum_btn_arr[][] = new AppCompatButton[4][4];
    private Handler handler;


    //private SoundPool soundPool;
    private int soundDrum[] = new int[16];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DrumViewModel drumViewModel =
                new ViewModelProvider(this).get(DrumViewModel.class);

        binding = FragmentDrumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.drumGl;
        final Drawable originalBackground = setOriginalBackground();


        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4; j++){
                String buttonId = "drum_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                drum_btn_arr[i][j] = root.findViewById(resId);
            }
        }
        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(16).build();


        int[][] drum_sound_id= {
                {R.raw.crash_cymbal, R.raw.tom_high, R.raw.tom_mid, R.raw.tom_low},
                {R.raw.ride_cymbal, R.raw.shaker, R.raw.cowbell, R.raw.highhat_closed},
                {R.raw.splash_cymbal, R.raw.snare, R.raw.tambourine, R.raw.highhat_opened},
                {R.raw.kick, R.raw.reverse_cymbal, R.raw.clap, R.raw.rimshot}

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

        float[][] drum_sound_duration = new float[4][4];
        MediaPlayer mediaPlayer[][] = new MediaPlayer[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mediaPlayer[i][j] = MediaPlayer.create(getContext(), drum_sound_id[i][j]);
                drum_sound_duration[i][j] = mediaPlayer[i][j].getDuration();
                mediaPlayer[i][j].release();
            }
        }


        // gonna change all methods below --> pushDrumBtn()
        // crash cymbal
        drum_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(0,0,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });


        // Tom(high)
        drum_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(0,1,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);
            }
        });

        // Tom(mid)
        drum_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(0,2,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // Tom (low)
        drum_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(0,3,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // Ride Cymbal
        drum_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(1,0,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // Shaker
        drum_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(1,1,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // cowbell
        drum_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(1,2,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // High Hat(closed)
        drum_btn_arr[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(1,3,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // splash cymbal
        drum_btn_arr[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(2,0,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        //snare
        drum_btn_arr[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(2,1,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        //tambourine
        drum_btn_arr[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(2,2,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);
            }
        });

        // high hat (opened)
        drum_btn_arr[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(2,3,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);
            }
        });

        // kick
        drum_btn_arr[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(3,0,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        //reverse symbal
        drum_btn_arr[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(3,1,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // clap
        drum_btn_arr[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(3,2,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });

        // rim shot
        drum_btn_arr[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDrumBtn(3,3,"#DD0000","#DD0000",soundPool, drum_soundpool, drum_sound_duration, originalBackground);

            }
        });
        return root;
    }


    private void pushDrumBtn(int i,
                             int j,
                             String centerColor,
                             String edgeColor,
                             SoundPool soundPool,
                             int[][] drum_soundpool,
                             float[][] drum_sound_duration,
                             Drawable originalBackground){
        soundPool.play(drum_soundpool[i][j],1.0f, 1.0f,1,0,1.0f);

        setGradientAnim(
                drum_btn_arr[i][j],
                centerColor,
                edgeColor, (long) drum_sound_duration[i][j]
        );

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(()-> {
            //Drawable orignalBackground = null;
            drum_btn_arr[i][j].setBackground(originalBackground);
        }, (long) drum_sound_duration[i][j]);


    }

    private void setGradientAnim(AppCompatButton button, String colorCenter, String colorEdge, long soundDuration){
        button.post(() -> {
            GradientDrawable gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[]{Color.WHITE, Color.parseColor(colorEdge), Color.parseColor(colorCenter)}
            );

            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);

            ValueAnimator animator = ValueAnimator.ofFloat(50f, 250f);
            animator.setDuration(soundDuration / 2);
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.setRepeatCount(ValueAnimator.INFINITE);


            animator.addUpdateListener(animation -> {
                float radius = (float) animation.getAnimatedValue();
                gradientDrawable.setGradientRadius(radius);
                button.invalidate();
            });
            animator.start();

            int cornerRadius = dpToPx(button ,4);
            gradientDrawable.setCornerRadius(cornerRadius);
            int p = dpToPx(button, 5);
            InsetDrawable insetDrawable= new InsetDrawable(gradientDrawable,p/2,p,p/2,p);

            button.setBackground(insetDrawable);
        });
    }
    private int dpToPx(AppCompatButton button, int dp) {
        return (int) (dp * button.getContext().getResources().getDisplayMetrics().density);
    }

    private int dpToPx(int dp){
        return (int) (dp);
    }

    private InsetDrawable setOriginalBackground(){
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                new int[]{Color.parseColor("#252525"),  Color.parseColor("#000000")}
        );

        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gradientDrawable.setGradientRadius(200f);
        int r = dpToPx(10);
        gradientDrawable.setCornerRadius(r);
        int p = dpToPx(10);
        InsetDrawable insetDrawable = new InsetDrawable(gradientDrawable, p / 2, p, p / 2, p);
        return insetDrawable;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}