package com.quang.wallpaper;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.quang.wallpaper.adapter.MyFavoriteAdapter;
import com.quang.wallpaper.api.PolyRetrofit;
import com.quang.wallpaper.modelcategorie.Categorie;
import com.quang.wallpaper.modelcategory.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFavorites_Fragment extends Fragment  {
    private GridView gridView;
    private  List<Category> cateList;
    private MyFavoriteAdapter myFavoriteAdapter;
//    static final String[] MOBILE_OS = new String[] {
//            "10", "20","35", "40","50", "15","17", "19"  };
    public MyFavorites_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_my_favorites_, container, false);
       gridView = view.findViewById(R.id.gridView);
       myFavoriteAdapter = new MyFavoriteAdapter(getActivity(),cateList);
//       gridView.setAdapter(new MyFavoriteAdapter(getActivity(),MOBILE_OS));
        loadPostOfCategory();
       return view;
    }
    public void loadPostOfCategory() {

        PolyRetrofit.getInstance().getCategory("18").enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.code()==200){
                    ShowCategory(response.body());
                   }
                    Log.e("daaa", response.code() + "");

                }
            private void ShowCategory(List<Category> response) {
                MyFavoriteAdapter showAdapter = new MyFavoriteAdapter(response, getActivity());
                gridView.setAdapter(showAdapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("ABC", t.getMessage());

            }
        });
    }
}
