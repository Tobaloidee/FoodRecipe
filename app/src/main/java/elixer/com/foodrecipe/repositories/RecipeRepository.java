package elixer.com.foodrecipe.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import elixer.com.foodrecipe.RecipeListActivity;
import elixer.com.foodrecipe.models.Recipe;
import elixer.com.foodrecipe.requests.RecipeApiClient;

public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;


    public static RecipeRepository getInstance(){
        if(instance == null){
            instance = new RecipeRepository();

        }
        return instance;
    }
    private RecipeRepository(){
       mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber){
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mRecipeApiClient.searchRecipesApi(query, pageNumber);
    }
}
