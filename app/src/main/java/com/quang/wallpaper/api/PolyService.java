package com.quang.wallpaper.api;

import com.quang.wallpaper.modelcategorie.Categorie;
import com.quang.wallpaper.modelcategory.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PolyService {
    @GET("wp-json/wp/v2/categories")
    Call<List<Categorie>> getCategories(@Query("page") int page, @Query("per_page")int per_page);

    @GET("wp-json/wp/v2/posts")
    Call<List<Category>> getCategory(@Query("category")String  category);

}
