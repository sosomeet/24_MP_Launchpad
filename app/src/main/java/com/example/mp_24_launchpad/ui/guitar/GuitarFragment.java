package com.example.mp_24_launchpad.ui.guitar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mp_24_launchpad.databinding.FragmentGuitarBinding;

public class GuitarFragment extends Fragment {

    private FragmentGuitarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GuitarViewModel guitarViewModel =
                new ViewModelProvider(this).get(GuitarViewModel.class);

        binding = FragmentGuitarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGuitar;
        guitarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}