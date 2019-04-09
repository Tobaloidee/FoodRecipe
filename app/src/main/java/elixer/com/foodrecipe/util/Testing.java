package elixer.com.foodrecipe.util;

import android.util.Log;

import java.util.List;

import elixer.com.foodrecipe.models.Recipe;

public class Testing {
    public  static void  printRecipes(List<Recipe> list, String tag)
    {
        for (Recipe recipe : list) {
            Log.d("TAG", recipe.getTitle());
        }

    }}
