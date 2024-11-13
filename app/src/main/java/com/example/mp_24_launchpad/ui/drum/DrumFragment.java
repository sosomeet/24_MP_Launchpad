package com.example.mp_24_launchpad.ui.drum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentDrumBinding;

public class DrumFragment extends Fragment {

    private FragmentDrumBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DrumViewModel drumViewModel =
                new ViewModelProvider(this).get(DrumViewModel.class);

        binding = FragmentDrumBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDrum;
        drumViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}