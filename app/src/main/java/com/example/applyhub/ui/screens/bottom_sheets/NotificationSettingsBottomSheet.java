package com.example.applyhub.ui.screens.bottom_sheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.applyhub.databinding.BottomSheetNotificationSettingsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class NotificationSettingsBottomSheet extends BottomSheetDialogFragment {
    private BottomSheetNotificationSettingsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = BottomSheetNotificationSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

