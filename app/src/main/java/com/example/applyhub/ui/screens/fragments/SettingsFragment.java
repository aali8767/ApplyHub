package com.example.applyhub.ui.screens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.applyhub.R;
import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.FragmentSettingsBinding;
import com.example.applyhub.databinding.ItemSettingBinding;
import com.example.applyhub.models.PolicyResponse;
import com.example.applyhub.ui.screens.activities.FAQsActivity;
import com.example.applyhub.ui.screens.activities.HelpFeedbackActivity;
import com.example.applyhub.ui.screens.bottom_sheets.LanguagePreferenceBottomSheet;
import com.example.applyhub.ui.screens.bottom_sheets.NotificationSettingsBottomSheet;
import com.example.applyhub.ui.screens.bottom_sheets.TitleDescriptionBottomSheet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupItem(binding.settingJobCountry, R.drawable.flag_24, "Job Preference Country", v -> openJobCountry());
        setupItem(binding.settingFaqs, R.drawable.question_mark_24, "FAQs", v -> openFQAsActivity());
        setupItem(binding.settingHelp, R.drawable.headset_mic_24, "Help & Feedback", v -> openHelp());
        setupItem(binding.settingPrivacy, R.drawable.police_24, "Privacy Policy", v -> openPrivacy());
        setupItem(binding.settingLanguage, R.drawable.global_24, "Language Preference", v -> openLanguage());
        setupItem(binding.settingNotifications, R.drawable.ic_notifications, "Notification Settings", v -> openNotifications());
    }

    private void setupItem(
            ItemSettingBinding itemBinding,
            @DrawableRes int iconRes,
            String title,
            View.OnClickListener onClickListener
    ) {
        itemBinding.iconSetting.setImageResource(iconRes);
        itemBinding.titleSetting.setText(title);
        itemBinding.getRoot().setOnClickListener(onClickListener);
    }

    private void openJobCountry() {

    }

    private void openFQAsActivity() {
        startActivity(
                new Intent(requireContext(), FAQsActivity.class)
        );
    }

    private void openHelp() {
        startActivity(
                new Intent(requireContext(), HelpFeedbackActivity.class)
        );
    }

    private void openPrivacy() {
        Retrofit retrofit = RetrofitClient.getInstance(requireContext());
        JobApiService apiService = retrofit.create(JobApiService.class);

        apiService.getPolicies().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<PolicyResponse> call, @NonNull Response<PolicyResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String title = response.body().getData().getTitle();
                    String desc = response.body().getData().getDescription();

                    TitleDescriptionBottomSheet sheet = TitleDescriptionBottomSheet.newInstance(
                            title,
                            desc
                    );
                    sheet.show(
                            requireActivity().getSupportFragmentManager(),
                            "TitleDescriptionBottomSheet"
                    );
                }
            }

            @Override
            public void onFailure(@NonNull Call<PolicyResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void openLanguage() {
        new LanguagePreferenceBottomSheet().show(
                requireActivity().getSupportFragmentManager(),
                "LanguagePreferenceSheet"
        );
    }

    private void openNotifications() {
        new NotificationSettingsBottomSheet().show(
                requireActivity().getSupportFragmentManager(),
                "NotificationSheet"
        );
    }
}