package com.example.recipeappmvp.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.recipeappmvp.R;
import com.example.recipeappmvp.databinding.HeaderColumnItemBinding;
import com.example.recipeappmvp.network.response.Meals;
import com.example.recipeappmvp.network.response.Meals.Meal;
import java.util.List;

public class ViewPagerHeaderAdapter extends RecyclerView.Adapter<ViewPagerHeaderAdapter.ViewHolder> {

  private List<Meal> meals;
  private Context context;
  private static OnItemClickListener clickListener;

  public ViewPagerHeaderAdapter(List<Meals.Meal> meals, Context context) {
    this.meals = meals;
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    HeaderColumnItemBinding binding = HeaderColumnItemBinding.inflate(layoutInflater, parent, false);
    return new ViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewPagerHeaderAdapter.ViewHolder holder, int position) {
    holder.bind(context, meals.get(position));
  }

  @Override
  public int getItemCount() {
    if (meals != null) {
      return meals.size();
    }
    return 0;
  }

  static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private HeaderColumnItemBinding binding;

    public ViewHolder(HeaderColumnItemBinding binding) {
      super(binding.getRoot());
      itemView.setOnClickListener(this);
      this.binding = binding;
    }

    @Override
    public void onClick(View v) {
      clickListener.onClick(v, getAdapterPosition());
    }

    public void bind(Context context, Meal meal) {
      String strMealThumb = meal.getStrMealThumb();
      Glide.with(context)
          .load(strMealThumb)
          .placeholder(R.drawable.ic_circle)
          .centerCrop()
          .into(binding.mealThumb);
      String strMealName = meal.getStrMeal();
      binding.mealName.setText(strMealName);
    }

  }

  public void setOnItemClickListener(OnItemClickListener clickListener) {
    ViewPagerHeaderAdapter.clickListener = clickListener;
  }

  public interface OnItemClickListener {

    void onClick(View view, int position);
  }
}