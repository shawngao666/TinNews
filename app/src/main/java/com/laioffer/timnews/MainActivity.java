package com.laioffer.timnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.timnews.model.NewsResponse;
import com.laioffer.timnews.network.NewsApi;
import com.laioffer.timnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        // bind these three fragments together to make sure we can switch between them
        NavigationUI.setupWithNavController(navView, navController); //这句话能把fragments 给连起来，你才可以来回点击切换。
        // 为什么能够把bottom_nav_menu和nav_graph连接起来？ 因为 id一样。
        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}