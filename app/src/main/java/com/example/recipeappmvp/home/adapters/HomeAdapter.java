package com.example.recipeappmvp.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.recipeappmvp.R;
import com.example.recipeappmvp.databinding.CategoryRowItemBinding;
import com.example.recipeappmvp.network.response.Categories;
import com.example.recipeappmvp.network.response.Categories.Category;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

  private List<Category> categories;
  private Context context;
  private static OnItemClickListener clickListener;

  public HomeAdapter(List<Categories.Category> categories, Context context) {
    this.categories = categories;
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    CategoryRowItemBinding binding = CategoryRowItemBinding.inflate(layoutInflater, parent, false);
    return new ViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(context, categories.get(position));
  }

  @Override
  public int getItemCount() {
    if (categories != null) {
      return categories.size();
    }
    return 0;
  }

  static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CategoryRowItemBinding binding;

    public ViewHolder(CategoryRowItemBinding binding) {
      super(binding.getRoot());
      itemView.setOnClickListener(this);
      this.binding = binding;
    }

    @Override
    public void onClick(View v) {
      clickListener.onClick(v, getAdapterPosition());
    }

    public void bind(Context context, Category category) {
      binding.categoryName.setText(category.getStrCategory());
      String strCategoryThum = category.getStrCategoryThumb();
      Glide.with(context)
          .load(strCategoryThum)
          .placeholder(R.drawable.ic_circle)
          .centerCrop()
          .into(binding.categoryThumb);
    }

  }

  public void setOnItemClickListener(OnItemClickListener clickListener) {
    HomeAdapter.clickListener = clickListener;
  }

  public interface OnItemClickListener {

    void onClick(View view, int position);
  }

}