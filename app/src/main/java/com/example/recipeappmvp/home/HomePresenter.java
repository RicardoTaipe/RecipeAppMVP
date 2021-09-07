package com.example.recipeappmvp.home;

import androidx.annotation.NonNull;
import com.example.recipeappmvp.Utils;
import com.example.recipeappmvp.network.response.Categories;
import com.example.recipeappmvp.network.response.Meals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

  private HomeView homeView;

  public HomePresenter(HomeView homeView) {
    this.homeView = homeView;
  }

  void getMeals() {
    homeView.showLoading();

    Call<Meals> mealsCall = Utils.getApi().getMeals("American");

    mealsCall.enqueue(new Callback<Meals>() {
      @Override
      public void onResponse(@NonNull Call<Meals> call, Response<Meals> response) {
        homeView.hideLoading();
        if (response.isSuccessful() && response.body() != null) {
          homeView.setMeal(response.body().getMeals());
        } else {
          homeView.onErrorLoading(response.message());
        }
      }

      @Override
      public void onFailure(@NonNull Call<Meals> call, @NonNull Throwable t) {
        homeView.hideLoading();
        homeView.onErrorLoading(t.getLocalizedMessage());
      }
    });
  }

  void getCategories() {
    homeView.showLoading();

    Call<Categories> categoriesCall = Utils.getApi().getCategories();
    categoriesCall.enqueue(new Callback<Categories>() {
      @Override
      public void onResponse(Call<Categories> call, Response<Categories> response) {
        homeView.hideLoading();
        if (response.isSuccessful() && response.body() != null) {
          homeView.setCategory(response.body().getCategories());
        } else {
          homeView.onErrorLoading(response.message());
        }
      }

      @Override
      public void onFailure(@NonNull Call<Categories> call, @NonNull Throwable t) {
        homeView.hideLoading();
        homeView.onErrorLoading(t.getLocalizedMessage());
      }
    });
  }

}


