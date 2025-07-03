package com.example.applyhub.ui.screens.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.applyhub.R;
import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.ActivityJobDetailsBinding;
import com.example.applyhub.models.Job;
import com.example.applyhub.models.JobDetailsResponse;
import com.example.applyhub.models.Skill;
import com.example.applyhub.ui.screens.bottom_sheets.LoginSignupBottomSheet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JobDetailsActivity extends AppCompatActivity {
    private ActivityJobDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int jobId = getIntent().getIntExtra("jobId", -1);
        if (jobId == -1) return;

        binding.contentView.setVisibility(View.GONE);

        Retrofit retrofit = RetrofitClient.getInstance(getBaseContext());
        JobApiService api = retrofit.create(JobApiService.class);

        api.getJobDetails(jobId).enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<JobDetailsResponse> call, @NonNull Response<JobDetailsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.contentView.setVisibility(View.VISIBLE);

                    Job job = response.body().getData();

                    binding.tvCreateTime.setText(job.getCreate_time() == null ? "null" : job.getCreate_time());
                    binding.tvCountryOfResidence.setText(job.getCountry_of_residence() == null ? "null" : job.getCountry_of_residence().getName());
                    binding.tvBusinessManName.setText(job.getBusiness_man().getBusiness_name() == null ? "null" : job.getBusiness_man().getBusiness_name());
                    binding.tvCountryOfEmploymentName.setText(job.getCountry_of_employment().getName());
                    binding.tvSalary.setText(job.getSalary() == null ? "null" : job.getSalary());
                    binding.tvEducationFeild.setText(job.getEducation_feild().getName());
                    binding.tvExperienceYear.setText(job.getExperience_year().getName());
                    binding.tvGenderPerfrence.setText(job.getGender_perfrence() == null ? "null" : job.getGender_perfrence());
                    binding.tvNationalityPrefrence.setText(job.getNationality_prefrence() == null ? "null" : job.getNationality_prefrence().getName());
                    binding.tvTitle.setText(job.getTitle());
                    binding.tvWatchesCount.setText(String.valueOf(job.getWatches_count()));
                    binding.tvSummary.setText(String.valueOf(job.getSummary()));

                    Glide
                            .with(getBaseContext())
                            .load(job.getCountry_of_employment().getCountry_image())
                            .centerCrop()
                            .circleCrop()
                            .placeholder(com.example.applyhub.R.drawable.global_24)
                            .into(binding.ivCountryOfEmployment);

                    Glide
                            .with(getBaseContext())
                            .load(job.getBusiness_man().getImage_url())
                            .centerCrop()
                            .circleCrop()
                            .placeholder(R.drawable.global_24)
                            .into(binding.ivBusinessMan);

                    if (job.getSkills() != null && !job.getSkills().isEmpty()) {
                        for (Skill skill : job.getSkills()) {
                            TextView chip = new TextView(getBaseContext());
                            chip.setText(skill.getName());
                            chip.setPadding(50, 20, 50, 20);
                            chip.setTextColor(Color.parseColor("#4BA8A4"));
                            chip.setTextSize(15);
                            chip.setBackground(ContextCompat.getDrawable(getBaseContext(), R.drawable.bg_skill_chip));
                            chip.setLayoutParams(
                                    new ViewGroup.MarginLayoutParams(
                                            ViewGroup.LayoutParams.WRAP_CONTENT,
                                            ViewGroup.LayoutParams.WRAP_CONTENT
                                    )
                            );

                            ((ViewGroup.MarginLayoutParams) chip.getLayoutParams()).setMargins(8, 8, 8, 8);
                            binding.skillsContainer.addView(chip);
                        }
                    } else {
                        binding.tvSkills.setVisibility(View.GONE);
                        binding.skillsContainer.setVisibility(View.GONE);
                    }

                    binding.ivBusinessMan.setOnClickListener(view -> {
                        Intent intent = new Intent(getBaseContext(), BusinessManActivity.class);
                        intent.putExtra("business_man", job.getBusiness_man());
                        intent.putExtra("country_image", job.getCountry_of_employment().getCountry_image());
                        intent.putExtra("country_name", job.getCountry_of_employment().getName());
                        startActivity(intent);
                    });

                    binding.btnApply.setOnClickListener(view -> {
                        new LoginSignupBottomSheet().show(
                                getSupportFragmentManager(),
                                "LoginSignupBottomSheet"
                        );
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<JobDetailsResponse> call, @NonNull Throwable t) {
                binding.progressBar.setVisibility(View.GONE);

                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}