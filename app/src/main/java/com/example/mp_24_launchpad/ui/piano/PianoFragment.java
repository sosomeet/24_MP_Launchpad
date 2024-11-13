package com.example.mp_24_launchpad.ui.piano;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentPianoBinding;

public class PianoFragment extends Fragment {

    private FragmentPianoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PianoViewModel pianoViewModel =
                new ViewModelProvider(this).get(PianoViewModel.class);

        binding = FragmentPianoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPiano;
        pianoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}