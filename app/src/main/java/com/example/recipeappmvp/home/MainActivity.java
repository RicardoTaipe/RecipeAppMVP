package com.example.recipeappmvp.home;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recipeappmvp.databinding.ActivityMainBinding;
import com.example.recipeappmvp.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private HomePresenter homePresenter;

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

    homePresenter = new HomePresenter(homeFragment);

  }

}