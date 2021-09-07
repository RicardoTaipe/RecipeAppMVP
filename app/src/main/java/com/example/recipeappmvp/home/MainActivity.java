package com.example.recipeappmvp.home;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipeappmvp.databinding.ActivityMainBinding;
import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeView {

  private ActivityMainBinding binding;
  private HomePresenter homePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

//    homePresenter = new HomePresenter(this);
//    homePresenter.getMeals();
//    homePresenter.getCategories();
  }

  @Override
  public void showLoading() {
//    binding.shimmerMeal.getRoot().setVisibility(View.VISIBLE);
//    binding.shimmerCategory.getRoot().setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
//    binding.shimmerMeal.getRoot().setVisibility(View.GONE);
//    binding.shimmerCategory.getRoot().setVisibility(View.GONE);
  }

  @Override
  public void setMeal(List<Meal> meal) {
  }

  @Override
  public void setCategory(List<Category> category) {

  }

  @Override
  public void onErrorLoading(String message) {

  }
}