package com.quang.wallpaper;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  DrawerLayout drawerLayout;
    private boolean anhien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (anhien==false){
//                    HienFl();
//                    anhien =  true;
//                }
//                else{
//                    AnFl();
//                    anhien = false;
//                }
//            }
//        });
        setSupportActionBar(toolbar);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Category_Fragment()).commit();
        getSupportActionBar().setTitle("Category");
        drawerLayout.closeDrawers();
        navigationView.setNavigationItemSelectedListener(this);
    }
//    private void HienFl(){
//        FloatingActionButton flbsua = findViewById(R.id.flsua);
//        FloatingActionButton flbthem = findViewById(R.id.flthem);
//        FloatingActionButton  flbxoa = findViewById(R.id.flxoa);
//        flbxoa.show();
//        flbthem.show();
//        flbsua.show();
//    }
//    private void AnFl(){
//        FloatingActionButton flbsua = findViewById(R.id.flsua);
//        FloatingActionButton flbthem = findViewById(R.id.flthem);
//        FloatingActionButton  flbxoa = findViewById(R.id.flxoa);
//        flbsua.hide();
//        flbthem.hide();
//        flbxoa.hide();
//    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_latest) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MyFavorites_Fragment()).commit();
            getSupportActionBar().setTitle("Latest");
            drawerLayout.closeDrawers();
        } else if (id == R.id.nav_category) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new Category_Fragment()).commit();
            getSupportActionBar().setTitle("Category");
            drawerLayout.closeDrawers();
        } else if (id == R.id.nav_gif) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MyFavorites_Fragment()).commit();
            getSupportActionBar().setTitle("Gifs");
            drawerLayout.closeDrawers();

        } else if (id == R.id.nav_myfavorite) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MyFavorites_Fragment()).commit();
            getSupportActionBar().setTitle("My Favorite");
            drawerLayout.closeDrawers();
        }
        else if(id==R.id.nav_aBout){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AboutUs_Fragment()).commit();
            getSupportActionBar().setTitle("About Us");
            drawerLayout.closeDrawers();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
