package com.example.applyhub.ui.screens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.FragmentJobsBinding;
import com.example.applyhub.models.Job;
import com.example.applyhub.models.JobsResponse;
import com.example.applyhub.ui.adapters.JobAdapter;
import com.example.applyhub.ui.screens.activities.JobDetailsActivity;
import com.example.applyhub.ui.screens.bottom_sheets.ShareViewBottomSheet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JobsFragment extends Fragment implements JobAdapter.OnJobClickListener {
    private FragmentJobsBinding binding;

    public JobsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = RetrofitClient.getInstance(requireContext());
        JobApiService apiService = retrofit.create(JobApiService.class);

        apiService.getAllJobs().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<JobsResponse> call, @NonNull Response<JobsResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isStatus()) {
                    List<Job> jobs = response.body().getData();
                    JobAdapter adapter = new JobAdapter(jobs, JobsFragment.this);
                    binding.recyclerViewJobs.setLayoutManager(new LinearLayoutManager(requireContext()));
                    binding.recyclerViewJobs.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<JobsResponse> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onJobClick(int jobId) {
        Intent intent = new Intent(requireContext(), JobDetailsActivity.class);
        intent.putExtra("jobId", jobId);

        startActivity(intent);
    }

    @Override
    public void onShareClick() {
        new ShareViewBottomSheet().show(
                requireActivity().getSupportFragmentManager(),
                "ShareViewBottomSheet"
        );
    }

    @Override
    public void onAddToBookmarksClick(int jobId) {

    }
}