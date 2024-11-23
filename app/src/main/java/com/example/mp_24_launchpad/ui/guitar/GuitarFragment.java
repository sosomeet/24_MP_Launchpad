package com.example.mp_24_launchpad.ui.guitar;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
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

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.R;
import com.example.mp_24_launchpad.databinding.FragmentGuitarBinding;

public class GuitarFragment extends Fragment {

    private FragmentGuitarBinding binding;
    AppCompatButton guitar_btn_arr[][] = new AppCompatButton[4][4];
    ImageView guitar_icon_arr[][] = new ImageView[4][4];
    int guitar_icon_res_arr[][] = new int[4][4];
    private Handler handler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GuitarViewModel guitarViewModel =
                new ViewModelProvider(this).get(GuitarViewModel.class);

        binding = FragmentGuitarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridLayout gridLayout = binding.guitarGl;

        final Drawable originalBackground = setOriginalBackground();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonId = "guitar_" + i + j + "_btn";
                int resId = getResources().getIdentifier(buttonId, "id", getContext().getPackageName());
                guitar_btn_arr[i][j] = root.findViewById(resId);
                guitar_btn_arr[i][j].setBackground(originalBackground);

                String iconId = "guitar_" + i + j + "_icon";
                int resId2 = getResources().getIdentifier(iconId, "id", getContext().getPackageName());
                guitar_icon_arr[i][j] = root.findViewById(resId2);
            }
        }

        guitar_icon_res_arr = new int[][]{
                {R.drawable.guitar_00_icon, R.drawable.guitar_01_icon, R.drawable.guitar_02_icon, R.drawable.guitar_03_icon},
                {R.drawable.guitar_10_icon, R.drawable.guitar_11_icon, R.drawable.guitar_12_icon, R.drawable.guitar_13_icon},
                {R.drawable.guitar_20_icon, R.drawable.guitar_21_icon, R.drawable.guitar_22_icon, R.drawable.guitar_23_icon},
                {R.drawable.guitar_30_icon, R.drawable.guitar_31_icon, R.drawable.guitar_32_icon, R.drawable.guitar_33_icon}
        };

        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(16).build();

        // bring the guitar resources id from R.raw
        int[][] guitar_sound_raw = {
                {R.raw.guitar_00, R.raw.guitar_01, R.raw.guitar_02, R.raw.guitar_03},
                {R.raw.guitar_10, R.raw.guitar_11, R.raw.guitar_12, R.raw.guitar_13},
                {R.raw.guitar_20, R.raw.guitar_21, R.raw.guitar_22, R.raw.guitar_23},
                {R.raw.guitar_30, R.raw.guitar_31, R.raw.guitar_32, R.raw.guitar_33}
        };

        // set the guitar resources for use soundPool
        int[][] guitar_soundpool = {
                {soundPool.load(getContext(), guitar_sound_raw[0][0], 1),
                        soundPool.load(getContext(), guitar_sound_raw[0][1], 1),
                        soundPool.load(getContext(), guitar_sound_raw[0][2], 1),
                        soundPool.load(getContext(), guitar_sound_raw[0][3], 1)},
                {soundPool.load(getContext(), guitar_sound_raw[1][0], 1),
                        soundPool.load(getContext(), guitar_sound_raw[1][1], 1),
                        soundPool.load(getContext(), guitar_sound_raw[1][2], 1),
                        soundPool.load(getContext(), guitar_sound_raw[1][3], 1)},
                {soundPool.load(getContext(), guitar_sound_raw[2][0], 1),
                        soundPool.load(getContext(), guitar_sound_raw[2][1], 1),
                        soundPool.load(getContext(), guitar_sound_raw[2][2], 1),
                        soundPool.load(getContext(), guitar_sound_raw[2][3], 1)},
                {soundPool.load(getContext(), guitar_sound_raw[3][0], 1),
                        soundPool.load(getContext(), guitar_sound_raw[3][1], 1),
                        soundPool.load(getContext(), guitar_sound_raw[3][2], 1),
                        soundPool.load(getContext(), guitar_sound_raw[3][3], 1)}
        };

        float[][] guitar_sound_duration = new float[4][4];
        MediaPlayer mediaPlayer[][] = new MediaPlayer[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mediaPlayer[i][j] = MediaPlayer.create(getContext(), guitar_sound_raw[i][j]);
                guitar_sound_duration[i][j] = mediaPlayer[i][j].getDuration();
                mediaPlayer[i][j].release();
            }
        }

        guitar_btn_arr[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pushBtn(btn row, btn col, center color, edge color, etc var(DO NOT MISS OR CHANGE))
                pushBtn(0, 0, "#FF54F4", "#FF00EE", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(0, 1, "#f8e602", "#4bff21", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(0, 2, "#FF5876", "#C0263E", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(0, 3, "#F0C9C2", "#5AB7FA", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(1, 0, "#00f0ff", "#00FFFF", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(1, 1, "#643C34", "#301713", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(1, 2, "#C0FCE2", "#73C7B0", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(1, 3, "#FF72E0", "#F898B3", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });
        guitar_btn_arr[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(2, 0, "#A8241F", "#3E1116", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(2, 1, "#566BC4", "#393E95", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);
            }
        });

        guitar_btn_arr[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(2, 2, "#E8AAE9", "#C7B6ED", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });

        guitar_btn_arr[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(2, 3, "#02C4BB", "#7C5E78", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });
        guitar_btn_arr[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(3, 0, "#F6D345", "#FE9402", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });

        guitar_btn_arr[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(3, 1, "#4FBEC9", "#3B9CA2", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });

        guitar_btn_arr[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(3, 2, "#D76FAC", "#C6446A", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });

        guitar_btn_arr[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushBtn(3, 3, "#E50914", "#B1060F", soundPool, guitar_soundpool, guitar_sound_duration, originalBackground);

            }
        });


        return root;
    }

    private void pushBtn(int i, int j, String centerColor, String edgeColor, SoundPool soundPool, int[][] guitar_soundpool, float[][] guitar_sound_duration, Drawable originalBackground) {
        // sound priority is higher than change color
        soundPool.play(guitar_soundpool[i][j], 1.0f, 1.0f, 1, 0, 1.0f);

        // icon to black
        Drawable drawable = guitar_icon_arr[i][j].getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap originalBitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap blackBitmap = makeImageBlack(originalBitmap, guitar_icon_arr[i][j].getWidth(), guitar_icon_arr[i][j].getHeight());
            guitar_icon_arr[i][j].setImageBitmap(blackBitmap);
        }

        // if sound is called, button color change
        setGradientAnim(
                guitar_btn_arr[i][j],
                centerColor,
                edgeColor,
                (long) guitar_sound_duration[i][j]
        );

        // if sound is end, color is roll back
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            guitar_btn_arr[i][j].setBackground(originalBackground);
            guitar_icon_arr[i][j].setImageResource(guitar_icon_res_arr[i][j]);
        }, (long) guitar_sound_duration[i][j] / 32);
    }

    private void setGradientAnim(AppCompatButton button, String centerColor, String edgeColor, long soundDuration) {
        button.post(() -> {
            // draw gradient
            GradientDrawable gradientDrawable = new GradientDrawable(
                    GradientDrawable.Orientation.TL_BR,
                    new int[]{Color.parseColor("#d5d5d5"), Color.parseColor(centerColor), Color.parseColor(edgeColor), Color.parseColor("#252525"), Color.parseColor("#080808")}
            );

            // gradient img shape
            gradientDrawable.setShape(GradientDrawable.RECTANGLE);
            // gradient shape (circle)
            gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);

            // gradient animation
            ValueAnimator animator = ValueAnimator.ofFloat(150f, 250f);
            animator.setDuration(soundDuration / 8);
            animator.setRepeatMode(ValueAnimator.REVERSE);

            animator.addUpdateListener(animation -> {
                float radius = (float) animation.getAnimatedValue();
                gradientDrawable.setGradientRadius(radius);
                button.invalidate();
            });

            animator.start();

            // set the gradient img to match the button size
            int cornerRadius = dpToPx(button, 4);
            gradientDrawable.setCornerRadius(cornerRadius);
            int p = dpToPx(button, 5);
            InsetDrawable insetDrawable = new InsetDrawable(gradientDrawable, p / 2, p, p / 2, p);

            // show gradient img
            button.setBackground(insetDrawable);
        });
    }

    private int dpToPx(AppCompatButton button, int dp) {
        // dp to px method
        return (int) (dp * button.getContext().getResources().getDisplayMetrics().density);
    }

    private static int dpToPx(int dp) {
        return (int) (dp);
    }

    private InsetDrawable setOriginalBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                new int[]{Color.parseColor("#252525"), Color.parseColor("#000000")}
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

    public static Bitmap makeImageBlack(Bitmap original, int w, int h) {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(original, dpToPx(50), dpToPx(50), true);

        Bitmap blackBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(blackBitmap);

        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(0xFF000000, PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(scaledBitmap, 0, 0, paint);

        return blackBitmap;
    }
}