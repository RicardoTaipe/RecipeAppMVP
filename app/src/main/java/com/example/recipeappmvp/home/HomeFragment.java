package com.example.recipeappmvp.home;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.recipeappmvp.databinding.FragmentHomeBinding;
import com.example.recipeappmvp.home.HomeContract.Presenter;
import com.example.recipeappmvp.home.adapters.HomeAdapter;
import com.example.recipeappmvp.home.adapters.ViewPagerHeaderAdapter;
import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import com.example.recipeappmvp.util.Utils;
import java.util.List;


public class HomeFragment extends Fragment implements HomeContract.View {

  private HomeContract.Presenter mPresenter;

  private FragmentHomeBinding binding;

  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override
  public void onResume() {
    super.onResume();
    mPresenter.start();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentHomeBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void showLoading() {
    binding.shimmerMeal.getRoot().setVisibility(View.VISIBLE);
    binding.shimmerCategory.getRoot().setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    binding.shimmerMeal.getRoot().setVisibility(View.GONE);
    binding.shimmerCategory.getRoot().setVisibility(View.GONE);
  }

  @Override
  public void setMeal(List<Meal> meal) {
    ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(meal, getContext());
    binding.viewPagerHeader.setAdapter(headerAdapter);
    headerAdapter.setOnItemClickListener((v, position) -> Toast.makeText(getContext(), meal.get(position).getStrMeal(), Toast.LENGTH_SHORT).show());
  }

  @Override
  public void setCategory(List<Category> category) {
    HomeAdapter homeAdapter = new HomeAdapter(category, getContext());
    binding.recyclerviewCategory.setAdapter(homeAdapter);
    GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
    binding.recyclerviewCategory.setLayoutManager(layoutManager);
    binding.recyclerviewCategory.setNestedScrollingEnabled(true);
    binding.recyclerviewCategory.setHasFixedSize(true);
    binding.recyclerviewCategory.setItemViewCacheSize(20);
    binding.recyclerviewCategory.setDrawingCacheEnabled(true);
    binding.recyclerviewCategory.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    homeAdapter.setOnItemClickListener(
        (view, position) -> Toast.makeText(getContext(), category.get(position).getStrCategory() + " pos " + position, Toast.LENGTH_SHORT).show());
  }

  @Override
  public void onErrorLoading(String message) {
    Utils.showDialogMessage(getContext(), "Uh-Oh", message);
  }

  @Override
  public void setPresenter(Presenter presenter) {
    mPresenter = presenter;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}