package com.example.recipeappmvp.home;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipeappmvp.databinding.ActivityMainBinding;
import com.example.recipeappmvp.home.HomePresenter;
import com.example.recipeappmvp.home.HomeView;
import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import com.example.recipeappmvp.util.ActivityUtils;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  //private HomePresenter homePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    final int contentFrame = binding.contentFrame.getId();
    HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(contentFrame);
    if (homeFragment == null) {
      homeFragment = HomeFragment.newInstance();
      ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment, contentFrame);
    }
  }

}