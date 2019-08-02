package com.quang.wallpaper;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quang.wallpaper.adapter.CategoryAdapter;
import com.quang.wallpaper.api.PolyRetrofit;
import com.quang.wallpaper.modelcategorie.Categorie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Category_Fragment extends Fragment {
    private RecyclerView rcvCategory;
    private List<Categorie> categories;
    private CategoryAdapter categoryAdapter;
    private SwipeRefreshLayout swipe;
    private int page = 1;
    private int per_page = 4;
    private TextView textView;
    private LinearLayoutManager linearLayoutManager;
    public Category_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_, container, false);

        rcvCategory = view.findViewById(R.id.rcvCategory);
        textView = view.findViewById(R.id.tv_hear_griview);
        categories = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getActivity(),categories);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(categoryAdapter);

        swipe = view.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                categories.clear();
                loadPostOfCategorie(page, per_page);
            }
        });
        rcvCategory.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadPostOfCategorie(page + 1, per_page);
            }
        });
        loadPostOfCategorie(page + 1, per_page);

        return view;
    }
    public void loadPostOfCategorie(int page,int per_page) {

        PolyRetrofit.getInstance().getCategories(page, per_page).enqueue(new Callback<List<Categorie>>() {
            @Override
            public void onResponse(Call<List<Categorie>> call, Response<List<Categorie>> response) {
                swipe.setRefreshing(false);
                if (response.body().size() == 0){
                    Log.e("daaa", String.valueOf(response.body().size()));
                    rcvCategory.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
                        @Override
                        public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                        }
                    });

                    categoryAdapter.setOnLoadMore(false);

                }

                categories.addAll(response.body());
                categoryAdapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(Call<List<Categorie>> call, Throwable t) {
                swipe.setRefreshing(false   );
                Log.e("ABC", t.getMessage());

            }
        });
    }
    public void It() {
        Intent intent = new Intent(getActivity(),ImageDetail_Activity.class);
        startActivity(intent);
    }

}
