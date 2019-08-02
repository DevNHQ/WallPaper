package com.quang.wallpaper.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.quang.wallpaper.R;
import com.quang.wallpaper.modelcategory.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyFavoriteAdapter  extends BaseAdapter {
    private List<Category> cateList;
    private  Context context;

    public MyFavoriteAdapter(List<Category> cateList, Context context) {
        this.cateList = cateList;
        this.context = context;
    }

    public MyFavoriteAdapter(FragmentActivity activity, List<Category> cateList) {
    }

    @Override
    public int getCount() {
        return cateList.size();
    }

    @Override
    public Object getItem(int i) {
        return cateList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.grfvr_item,viewGroup,false);
        }
        TextView text_eye = view.findViewById(R.id.tv_eye_gridview);
        TextView text_hear = view.findViewById(R.id.tv_hear_griview);
        ImageView imageView_grv = view.findViewById(R.id.img_griview);
        final Category category = cateList.get(i);
        text_eye.setText(""+category.getAuthor());
        text_hear.setText(""+category.getAuthor());
        Picasso.get().load("http://asian.dotplays.com/wp-content/uploads/2019/07/1236260893214-768x580.jpg").into(imageView_grv);

                            for(Category x : cateList) {
                                String[] src = x.getContent().getRendered().split("\\s");
                                for (String aa : src) {
                                    if (aa.startsWith("http:") && aa.endsWith("768x580.jpg")) {
                                        for (int j = 0; j < aa.length(); j++) {

                                            Log.e("dadadvaa422", aa);

                                        }

                                    }
                                }
                            }


//        if (category.getContent().getRendered() !=null){
//            Picasso.get().load(get)
//        }
        return view;
    }
}
