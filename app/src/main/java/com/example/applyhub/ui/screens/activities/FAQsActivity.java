package com.example.applyhub.ui.screens.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.applyhub.data.JobApiService;
import com.example.applyhub.data.RetrofitClient;
import com.example.applyhub.databinding.ActivityFaqsBinding;
import com.example.applyhub.models.FaqResponse;
import com.example.applyhub.ui.adapters.FaqAdapter;
import com.example.applyhub.ui.screens.bottom_sheets.TitleDescriptionBottomSheet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FAQsActivity extends AppCompatActivity {
    private ActivityFaqsBinding binding;
    private FaqAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFaqsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(v -> finish());

        Retrofit retrofit = RetrofitClient.getInstance(getBaseContext());
        JobApiService apiService = retrofit.create(JobApiService.class);

        apiService.getFaqs().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<FaqResponse> call, @NonNull Response<FaqResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    binding.progressBar.setVisibility(View.GONE);

                    List<FaqResponse.FaqItem> faqs = response.body().getData();

                    adapter = new FaqAdapter(faqs, (faqResponse) -> {
                        TitleDescriptionBottomSheet sheet = TitleDescriptionBottomSheet.newInstance(
                                faqResponse.getTitle(),
                                faqResponse.getDescription()
                        );
                        sheet.show(getSupportFragmentManager(), "TitleDescriptionBottomSheet");
                    });

                    binding.recyclerFaqs.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    binding.recyclerFaqs.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<FaqResponse> call, @NonNull Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
