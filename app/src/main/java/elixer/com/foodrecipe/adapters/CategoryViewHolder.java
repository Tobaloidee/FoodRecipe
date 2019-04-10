package elixer.com.foodrecipe.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import elixer.com.foodrecipe.R;
import elixer.com.foodrecipe.util.Testing;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener
{
    CircleImageView categoryImage;
    TextView categoryTitle;
    OnRecipeListener listener;

    public CategoryViewHolder(@NonNull View itemView, OnRecipeListener onRecipeListener) {
        super(itemView);
        categoryImage = itemView.findViewById(R.id.category_image);
        categoryTitle = itemView.findViewById(R.id.category_title);
        listener = onRecipeListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onCategoryClick(categoryTitle.getText().toString());
    }
}