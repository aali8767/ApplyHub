package com.example.applyhub.ui.screens.activities;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.applyhub.R;
import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.ActivityBusinessManBinding;
import com.example.applyhub.models.BusinessMan;
import com.example.applyhub.models.Job;
import com.example.applyhub.models.JobsResponse;
import com.example.applyhub.ui.adapters.JobAdapter;
import com.example.applyhub.ui.screens.bottom_sheets.LoginSignupBottomSheet;
import com.example.applyhub.ui.screens.bottom_sheets.TakeActionBottomSheet;
import com.example.applyhub.ui.screens.fragments.JobsFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BusinessManActivity extends AppCompatActivity implements JobAdapter.OnJobClickListener {
    private ActivityBusinessManBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusinessManBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BusinessMan businessMan = (BusinessMan) getIntent().getSerializableExtra("business_man");
        if (businessMan == null) return;

        Glide
                .with(getBaseContext())
                .load(businessMan.getImage_url())
                .centerCrop()
                .circleCrop()
                .placeholder(R.drawable.global_24)
                .into(binding.ivBusinessManImage);

        Glide
                .with(getBaseContext())
                .load(businessMan.getCover_url())
                .centerCrop()
                .circleCrop()
                .placeholder(R.color.black)
                .into(binding.ivBusinessManCover);

        binding.tvBusinessManName.setText(businessMan.getBusiness_name() == null ? "null" : businessMan.getBusiness_name());
        binding.tvBusinessManTelephone.setText(businessMan.getTelephone());
        binding.tvTypeBusiness.setText(String.valueOf(businessMan.getType_business()));
        binding.tvEmployeeNo.setText(String.valueOf(businessMan.getEmployee_no()));
        binding.tvBio.setText(String.valueOf(businessMan.getBio()));

        Retrofit retrofit = RetrofitClient.getInstance(getApplicationContext());
        JobApiService apiService = retrofit.create(JobApiService.class);

        apiService.getAllJobs().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<JobsResponse> call, @NonNull Response<JobsResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    binding.progressBar.setVisibility(View.GONE);

                    List<Job> jobs = response.body().getData();
                    JobAdapter adapter = new JobAdapter(jobs, BusinessManActivity.this);
                    binding.recyclerViewJobs.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.recyclerViewJobs.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<JobsResponse> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        binding.ivOptions.setOnClickListener(view -> new TakeActionBottomSheet().show(
                getSupportFragmentManager(),
                "TakeActionBottomSheet"
        ));
    }

    @Override
    public void onJobClick(int jobId) {

    }

    @Override
    public void onShareClick() {

    }

    @Override
    public void onAddToBookmarksClick(int jobId) {

    }
}