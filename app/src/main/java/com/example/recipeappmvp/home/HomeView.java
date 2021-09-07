package com.example.recipeappmvp.home;

import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import java.util.List;

public interface HomeView {
  void showLoading();
  void hideLoading();
  void setMeal(List<Meal> meal);
  void setCategory(List<Category> category);
  void onErrorLoading(String message);
}
