package elixer.com.foodrecipe.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import elixer.com.foodrecipe.models.Recipe;

public class RecipeListViewModel extends ViewModel {
    private MutableLiveData<List<Recipe>> mRecipes = new MutableLiveData<>();

    public RecipeListViewModel() {
    }

    public LiveData<List<Recipe>> getRecipe(){
        return mRecipes;
    }
}
