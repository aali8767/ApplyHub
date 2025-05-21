package com.example.applyhub.ui.screens.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applyhub.R;
import com.example.applyhub.databinding.ActivityJobDetailsBinding;

public class JobDetailsActivity extends AppCompatActivity {
    private ActivityJobDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}