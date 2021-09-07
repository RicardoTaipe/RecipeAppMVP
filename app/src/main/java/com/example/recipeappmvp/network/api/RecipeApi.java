package com.example.recipeappmvp.network.api;

import com.example.recipeappmvp.network.response.Categories;
import com.example.recipeappmvp.network.response.Meals;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

  @GET("filter.php")
  Call<Meals> getMeals(@Query("a") String area);

  @GET("categories.php")
  Call<Categories> getCategories();

  @GET("filter.php")
  Call<Meals> getMealByCategory(@Query("c") String category);

}
