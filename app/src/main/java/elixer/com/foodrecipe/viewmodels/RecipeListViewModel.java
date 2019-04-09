package elixer.com.foodrecipe.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import elixer.com.foodrecipe.models.Recipe;
import elixer.com.foodrecipe.repositories.RecipeRepository;

public class RecipeListViewModel extends ViewModel {
    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = (RecipeRepository) RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipe(){
        return mRecipeRepository.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber){

        mRecipeRepository.searchRecipesApi(query, pageNumber);
    }
}
