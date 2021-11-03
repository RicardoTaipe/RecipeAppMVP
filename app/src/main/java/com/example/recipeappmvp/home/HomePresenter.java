package com.example.recipeappmvp.home;

import androidx.annotation.NonNull;
import com.example.recipeappmvp.util.Utils;
import com.example.recipeappmvp.network.response.Categories;
import com.example.recipeappmvp.network.response.Meals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.Presenter {

  private final HomeContract.View homeView;

  public HomePresenter(HomeContract.View homeView) {
    this.homeView = homeView;
    homeView.setPresenter(this);
  }


  @Override
  public void start() {
    loadCategories();
    loadMeals();
  }

  @Override
  public void loadMeals() {
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

  @Override
  public void loadCategories() {
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


