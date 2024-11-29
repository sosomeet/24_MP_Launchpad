package com.example.mp_24_launchpad.ui.piano;

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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.R;
import com.example.mp_24_launchpad.databinding.FragmentPianoBinding;

public class PianoFragment extends Fragment {

    private FragmentPianoBinding binding;
    AppCompatButton piano_btn_arr[][] = new AppCompatButton[4][4];
    ImageView piano_icon_arr[][] = new ImageView[4][4];
    int piano_icon_res_arr[][] = new int[4][4];
    private Handler handler;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PianoViewModel pianoViewModel =
                new ViewModelProvider(this).get(PianoViewModel.class);

        binding = FragmentPianoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.pianoGl;

        final Drawable originalBackground = setOriginalBackground();


        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4; j++){
                String buttonId = "piano_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                piano_btn_arr[i][j] = root.findViewById(resId);
                piano_btn_arr[i][j].setBackground(originalBackground);

                String iconId = "piano_" + i + j + "_icon";
                int resId2 = getResources().getIdentifier(iconId, "id", getContext().getPackageName());
                piano_icon_arr[i][j] = root.findViewById(resId2);
            }
        }

        piano_icon_res_arr = new int[][]{
                {R.drawable.piano_00_icon, R.drawable.piano_01_icon, R.drawable.piano_02_icon, R.drawable.piano_03_icon},
                {R.drawable.piano_10_icon, R.drawable.piano_11_icon, R.drawable.piano_12_icon, R.drawable.piano_13_icon},
                {R.drawable.piano_20_icon, R.drawable.piano_21_icon, R.drawable.piano_22_icon, R.drawable.piano_23_icon},
                {R.drawable.piano_30_icon, R.drawable.piano_31_icon, R.drawable.piano_32_icon, R.drawable.piano_33_icon}
        };


        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(16).build();
        // bring the piano resources id from R.raw
        int[][] piano_sound_raw = {
                {R.raw.piano_00, R.raw.piano_01, R.raw.piano_02, R.raw.piano_03},
                {R.raw.piano_10, R.raw.piano_11, R.raw.piano_12, R.raw.piano_13},
                {R.raw.piano_20, R.raw.piano_21, R.raw.piano_22, R.raw.piano_23},
                {R.raw.piano_30, R.raw.piano_31, R.raw.piano_32, R.raw.piano_33}
        };
        // set the guitar resources for use soundPool
        int[][] piano_soundpool = {
                {soundPool.load(getContext(), piano_sound_raw[0][0], 1),
                        soundPool.load(getContext(), piano_sound_raw[0][1], 1),
                        soundPool.load(getContext(), piano_sound_raw[0][2], 1),
                        soundPool.load(getContext(), piano_sound_raw[0][3], 1)},
                {soundPool.load(getContext(), piano_sound_raw[1][0], 1),
                        soundPool.load(getContext(), piano_sound_raw[1][1], 1),
                        soundPool.load(getContext(), piano_sound_raw[1][2], 1),
                        soundPool.load(getContext(), piano_sound_raw[1][3], 1)},
                {soundPool.load(getContext(), piano_sound_raw[2][0], 1),
                        soundPool.load(getContext(), piano_sound_raw[2][1], 1),
                        soundPool.load(getContext(), piano_sound_raw[2][2], 1),
                        soundPool.load(getContext(), piano_sound_raw[2][3], 1)},
                {soundPool.load(getContext(), piano_sound_raw[3][0], 1),
                        soundPool.load(getContext(), piano_sound_raw[3][1], 1),
                        soundPool.load(getContext(), piano_sound_raw[3][2], 1),
                        soundPool.load(getContext(), piano_sound_raw[3][3], 1)}
        };

        float[][] piano_sound_duration = new float[4][4];
        MediaPlayer mediaPlayer[][] = new MediaPlayer[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mediaPlayer[i][j] = MediaPlayer.create(getContext(), piano_sound_raw[i][j]);
                piano_sound_duration[i][j] = mediaPlayer[i][j].getDuration();
                mediaPlayer[i][j].release();
            }
        }



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int row = i;
                final int col = j;

                piano_btn_arr[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pushBtn(row, col, soundPool, piano_soundpool, piano_sound_duration, originalBackground);

                    }
                });
            }
        }

        return root;
    }

    private void pushBtn(int i, int j, SoundPool soundPool, int[][] piano_soundpool, float[][] piano_sound_duration, Drawable originalBackground) {
        // 소리 재생
        soundPool.play(piano_soundpool[i][j], 1.0f, 1.0f, 1, 0, 1.0f);

        // 버튼과 아이콘 색상 변경
        final int borderWidth = dpToPx(5); // 테두리 두께 설정
        GradientDrawable borderDrawable = new GradientDrawable();
        borderDrawable.setColor(Color.parseColor("#d5d5d5"));
        borderDrawable.setShape(GradientDrawable.RECTANGLE);
        borderDrawable.setStroke(borderWidth, Color.parseColor("#F0CD01")); // 금색 (Gold)
        int r = dpToPx(10);
        borderDrawable.setCornerRadius(r);
        piano_btn_arr[i][j].setBackground(borderDrawable);
        // 음악이 끝난 후 색상 롤백
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            piano_btn_arr[i][j].setBackground(originalBackground); // 버튼 색상 원래대로
            piano_icon_arr[i][j].setImageResource(piano_icon_res_arr[i][j]); // 아이콘 원래대로
        }, (long) piano_sound_duration[i][j]/4);
    }
    private static int dpToPx(int dp) {
        return (int) (dp);
    }

    private InsetDrawable setOriginalBackground(){

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")}
        );

        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
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