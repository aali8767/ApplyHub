package com.example.applyhub.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://fursaty.kicklance.com/";
    private static Retrofit retrofit = null;
    private static final String PREF_NAME = "app_preferences";
    private static final String KEY_LANGUAGE = "selected_language";

    public static Retrofit getInstance(Context context) {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                        String lang = preferences.getString(KEY_LANGUAGE, "en");

                        Request original = chain.request();
                        HttpUrl originalHttpUrl = original.url();
                        List<String> pathSegments = originalHttpUrl.pathSegments();

                        HttpUrl.Builder newUrlBuilder = originalHttpUrl.newBuilder()
                                .encodedPath("/" + lang + "/" + String.join("/", pathSegments));

                        Request newRequest = original.newBuilder()
                                .url(newUrlBuilder.build())
                                .build();

                        return chain.proceed(newRequest);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }
}
