package com.example.applyhub.data;

import com.example.applyhub.models.ApiResponse;
import com.example.applyhub.models.FaqResponse;
import com.example.applyhub.models.PolicyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JobApiService {

    @GET("api/job-seeker/all-jobs")
    Call<ApiResponse> getAllJobs();

    @GET("api/faqs")
    Call<FaqResponse> getFaqs();

    @GET("api/policies")
    Call<PolicyResponse> getPolicies();

    @POST("api/feedback")
    Call<ApiResponse> sendFeedback(
            @Query("subject") String subject,
            @Query("details") String details,
            @Query("name") String name,
            @Query("email") String email
    );
}
