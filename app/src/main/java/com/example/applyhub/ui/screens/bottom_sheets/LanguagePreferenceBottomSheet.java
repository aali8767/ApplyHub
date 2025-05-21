package com.example.applyhub.ui.screens.bottom_sheets;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.applyhub.databinding.BottomSheetLanguagePreferenceBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class LanguagePreferenceBottomSheet extends BottomSheetDialogFragment {

    private BottomSheetLanguagePreferenceBinding binding;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "app_preferences";
    private static final String KEY_LANGUAGE = "selected_language";

    private String selectedLanguage = "en";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = BottomSheetLanguagePreferenceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        selectedLanguage = sharedPreferences.getString(KEY_LANGUAGE, "en");

        updateLanguageUI(selectedLanguage);

        binding.layoutArabic.setOnClickListener(v -> {
            saveLanguage("ar");
            updateLanguageUI("ar");
        });

        binding.layoutEnglish.setOnClickListener(v -> {
            saveLanguage("en");
            updateLanguageUI("en");
        });
    }

    private void updateLanguageUI(String lang) {
        if ("ar".equals(lang)) {
            binding.checkArabic.setVisibility(View.VISIBLE);
            binding.checkEnglish.setVisibility(View.GONE);
        } else {
            binding.checkArabic.setVisibility(View.GONE);
            binding.checkEnglish.setVisibility(View.VISIBLE);
        }
    }

    private void saveLanguage(String lang) {
        sharedPreferences.edit().putString(KEY_LANGUAGE, lang).apply();
        selectedLanguage = lang;
    }
}
