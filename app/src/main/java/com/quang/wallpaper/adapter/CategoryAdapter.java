package com.quang.wallpaper.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.quang.wallpaper.Category_Fragment;
import com.quang.wallpaper.MyFavorites_Fragment;
import com.quang.wallpaper.R;
import com.quang.wallpaper.holder.CateHolder;
import com.quang.wallpaper.holder.LoadHolder;
import com.quang.wallpaper.modelcategorie.Categorie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Category_Fragment category_fragment;
    private MyFavorites_Fragment myFavorites_fragment;
    private Context context;

    public CategoryAdapter(Category_Fragment category_fragment, MyFavorites_Fragment myFavorites_fragment, Context context, boolean onLoadMore, List<Categorie> categories, int ITEM, int LOAD_MORE) {
        this.category_fragment = category_fragment;
        this.myFavorites_fragment = myFavorites_fragment;
        this.context = context;
        this.onLoadMore = onLoadMore;
        this.categories = categories;
        this.ITEM = ITEM;
        this.LOAD_MORE = LOAD_MORE;
    }

    public boolean isOnLoadMore() {
        return onLoadMore;
    }

    public void setOnLoadMore(boolean onLoadMore) {
        this.onLoadMore = onLoadMore;
    }

    private boolean onLoadMore = true;

    private List<Categorie> categories;

    public CategoryAdapter(Context context, List<Categorie> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_category, parent, false);
            return new CateHolder(view);
        } else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.loadmore, parent, false);
            return new LoadHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CateHolder) {
            Categorie category = categories.get(position);
            ((CateHolder) holder).tvSlug.setText(category.getName());
            ((CateHolder) holder).tvCout.setText(""+"("+category.getCount()+")");
        } else if (holder instanceof LoadHolder){
        }
    }


    int ITEM = 1;
    int LOAD_MORE = 2;

    @Override
    public int getItemViewType(int position) {

        if (onLoadMore){
            if (position == categories.size() - 1) return LOAD_MORE;
            else return ITEM;
        }else return ITEM;

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
