package com.example.applyhub.ui.screens.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.ActivityHelpFeedbackBinding;
import com.example.applyhub.models.JobsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelpFeedbackActivity extends AppCompatActivity {
    private ActivityHelpFeedbackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(v -> finish());

        binding.btnSend.setOnClickListener(view -> {
            String subject = binding.etSubject.getText().toString().trim();
            String details = binding.etDetails.getText().toString().trim();
            String fullName = binding.etFullName.getText().toString().trim();
            String email = binding.etEmail.getText().toString().trim();

            Retrofit retrofit = RetrofitClient.getInstance(getBaseContext());
            JobApiService apiService = retrofit.create(JobApiService.class);

            apiService.sendFeedback(
                    subject,
                    details,
                    fullName,
                    email
            ).enqueue(new Callback<>() {
                @Override
                public void onResponse(@NonNull Call<JobsResponse> call, @NonNull Response<JobsResponse> response) {
                    if (response.body() != null) {
                        if (response.body().isStatus()) {
                            Toast.makeText(getBaseContext(), "تم الارسال بنجاح", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getBaseContext(), "خطأ في البيانات المدخلة", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<JobsResponse> call, @NonNull Throwable t) {
                    Toast.makeText(getBaseContext(), "حدث خطأ ما", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
