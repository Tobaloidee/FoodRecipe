package elixer.com.foodrecipe;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import elixer.com.foodrecipe.models.Recipe;
import elixer.com.foodrecipe.requests.RecipeApi;
import elixer.com.foodrecipe.requests.ServiceGenerator;
import elixer.com.foodrecipe.requests.responses.RecipeSearchResponse;
import elixer.com.foodrecipe.util.Constants;
import elixer.com.foodrecipe.util.Testing;
import elixer.com.foodrecipe.viewmodels.RecipeListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity{

    private static final String TAG = "RecipeListActivity";
    private RecipeListViewModel mRecipeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        subscribeObservers();
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        }

        private void subscribeObservers(){
        mRecipeListViewModel.getRecipe().observe(this, new Observer<List<Recipe>>() {
                    @Override
                    public void onChanged(@Nullable List<Recipe> recipes) {
                        if (recipes != null) {
                            Testing.printRecipes(recipes, "test");
                        }
                    }
                }

        );
        }

    private void searchRecipesApi(String query, int pageNumber){

        mRecipeListViewModel.searchRecipesApi(query, pageNumber);
    }


        private void test() {
        searchRecipesApi("chicken",1);

        }
//            RecipeApi recipeApi = ServiceGenerator.getRecipeApi();
//            Call<RecipeSearchResponse> responseCall = recipeApi.searchRecipe(Constants.API_KEY, "chicken", 1);
//            responseCall.enqueue(new Callback<RecipeSearchResponse>() {
//                @Override
//                public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
//                    Log.d(TAG, "onResponse: Server Response: " + response.toString());
//                    if (response.code() == 200) {
//                        List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
//                        for(Recipe recipe: recipes) {
//                            Log.d(TAG, "onResponse: " + recipe.getTitle());
//                        }
//                    }
//                    else{
//                        try {
//                            Log.d(TAG, "onResponse: " + response.errorBody().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {
//
//                }
//            });
//        }

    }
