package com.example.applyhub;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.applyhub.databinding.ActivityMainBinding;
import com.example.applyhub.ui.screens.fragments.BookmarksFragment;
import com.example.applyhub.ui.screens.fragments.JobsFragment;
import com.example.applyhub.ui.screens.fragments.ProfileFragment;
import com.example.applyhub.ui.screens.fragments.SettingsFragment;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final List<String> titles = Arrays.asList(
            "Fursati",
            "Bookmarks",
            "Settings",
            "Profile"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new JobsFragment());
        binding.bottomNavigationView.setSelectedItemId(R.id.nav_jobs);
        binding.headerTitle.setText(titles.get(0));

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Fragment selectedFragment = null;

            if (id == R.id.nav_jobs) {
                selectedFragment = new JobsFragment();
                binding.headerTitle.setText(titles.get(0));
            } else if (id == R.id.nav_bookmarks) {
                selectedFragment = new BookmarksFragment();
                binding.headerTitle.setText(titles.get(1));
            } else if (id == R.id.nav_settings) {
                selectedFragment = new SettingsFragment();
                binding.headerTitle.setText(titles.get(2));
            } else if (id == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
                binding.headerTitle.setText(titles.get(3));
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }

            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerView, fragment)
                .commit();
    }
}

