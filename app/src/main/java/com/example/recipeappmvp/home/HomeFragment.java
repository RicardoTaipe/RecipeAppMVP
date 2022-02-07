package com.example.recipeappmvp.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.recipeappmvp.category.adapters.CategoryPagerAdapter;
import com.example.recipeappmvp.databinding.FragmentHomeBinding;
import com.example.recipeappmvp.home.HomeContract.Presenter;
import com.example.recipeappmvp.home.adapters.HomeAdapter;
import com.example.recipeappmvp.home.adapters.ViewPagerHeaderAdapter;
import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import com.example.recipeappmvp.util.Utils;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;


public class HomeFragment extends Fragment implements HomeContract.View {

  private HomeContract.Presenter mPresenter;

  private FragmentHomeBinding binding;

  private List<Category> categories;

  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = FragmentHomeBinding.inflate(inflater, container, false);

    GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
    binding.recyclerviewCategory.setLayoutManager(layoutManager);
    binding.recyclerviewCategory.setNestedScrollingEnabled(true);
    binding.recyclerviewCategory.setHasFixedSize(true);
    binding.recyclerviewCategory.setItemViewCacheSize(20);
    binding.recyclerviewCategory.setDrawingCacheEnabled(true);
    binding.recyclerviewCategory.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

    mPresenter.start();
    return binding.getRoot();
  }

  @Override
  public void showLoading() {
    binding.shimmerMeal.setVisibility(View.VISIBLE);
    binding.shimmerCategory.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    binding.shimmerMeal.setVisibility(View.GONE);
    binding.shimmerCategory.setVisibility(View.GONE);
  }

  @Override
  public void setMeal(List<Meal> meal) {
    ViewPagerHeaderAdapter headerAdapter = new ViewPagerHeaderAdapter(meal, getContext());
    binding.viewPagerHeader.setAdapter(headerAdapter);
    headerAdapter.setOnItemClickListener((v, position) -> Toast.makeText(getContext(), meal.get(position).getStrMeal(), Toast.LENGTH_SHORT).show());
  }

  @Override
  public void setCategory(List<Category> category) {
    categories = category;
    HomeAdapter homeAdapter = new HomeAdapter(categories, getContext());
    binding.recyclerviewCategory.setAdapter(homeAdapter);
    homeAdapter.setOnItemClickListener(
        (view, position) -> Toast.makeText(getContext(), categories.get(position).getStrCategory() + " pos " + position, Toast.LENGTH_SHORT).show());

    CategoryPagerAdapter categoryPagerAdapter = new CategoryPagerAdapter(requireActivity(), categories);
    binding.categoryViewpager.setAdapter(categoryPagerAdapter);
    TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayoutCategory, binding.categoryViewpager,
        (tab, position) -> tab.setText(categories.get(position).getStrCategory()));
    tabLayoutMediator.attach();

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
//TODO https://dribbble.com/shots/7333348-ChefCraft/attachments/248232?mode=media
//https://dribbble.com/shots/9061561-Recipes-App/attachments/1158060?mode=media
//https://dribbble.com/shots/9061561-Recipes-App/attachments/1158060?mode=media
//https://dribbble.com/shots/7059758-BeChef-Cooking-App/attachments/60689?mode=media