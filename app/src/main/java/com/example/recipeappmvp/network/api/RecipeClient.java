package com.example.recipeappmvp.network.api;

import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeClient {

  private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

  public static Retrofit getRecipeClient() {
    return new Retrofit.Builder().baseUrl(BASE_URL)
        .client(provideOkHttp())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  private static OkHttpClient provideOkHttp() {
    return new OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build();
  }
}
