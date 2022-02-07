package com.example.recipeappmvp.category.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.recipeappmvp.category.CategoryFragment;
import com.example.recipeappmvp.network.response.Categories.Category;
import java.util.List;

public class CategoryPagerAdapter extends FragmentStateAdapter {
  private List<Category> categories;
  public CategoryPagerAdapter(@NonNull FragmentActivity fragmentActivity,
      List<Category> categories) {
    super(fragmentActivity);
    this.categories= categories;
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return new CategoryFragment();
  }

  @Override
  public int getItemCount() {
    return categories.size();
  }

}
