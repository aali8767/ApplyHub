package com.example.applyhub.ui.screens.bottom_sheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.applyhub.databinding.BottomSheetFaqBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TitleDescriptionBottomSheet extends BottomSheetDialogFragment {
    private BottomSheetFaqBinding binding;
    private static final String ARG_TITLE = "title";
    private static final String ARG_Description = "description";

    public static TitleDescriptionBottomSheet newInstance(String title, String description) {
        TitleDescriptionBottomSheet fragment = new TitleDescriptionBottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_Description, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = BottomSheetFaqBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            binding.tvTitle.setText(getArguments().getString(ARG_TITLE));
            binding.tvDescription.setText(getArguments().getString(ARG_Description));
        }
    }
}
