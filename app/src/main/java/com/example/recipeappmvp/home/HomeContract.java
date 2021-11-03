package com.example.recipeappmvp.home;

import com.example.recipeappmvp.BasePresenter;
import com.example.recipeappmvp.BaseView;
import com.example.recipeappmvp.network.response.Categories.Category;
import com.example.recipeappmvp.network.response.Meals.Meal;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HomeContract {

  interface View extends BaseView<Presenter> {

    void showLoading();

    void hideLoading();

    void setMeal(List<Meal> meal);

    void setCategory(List<Category> category);

    void onErrorLoading(String message);
  }

  interface Presenter extends BasePresenter {

    void loadMeals();

    void loadCategories();
  }

}
