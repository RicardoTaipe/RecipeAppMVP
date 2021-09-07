package com.example.recipeappmvp;

import android.app.AlertDialog;
import android.content.Context;
import com.example.recipeappmvp.network.api.RecipeApi;
import com.example.recipeappmvp.network.api.RecipeClient;

public class Utils {
  public static RecipeApi getApi() {
    return RecipeClient.getRecipeClient().create(RecipeApi.class);
  }

  public static AlertDialog showDialogMessage(Context context, String title, String message) {
    AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
    if (alertDialog.isShowing()) {
      alertDialog.cancel();
    }
    return alertDialog;
  }
}
