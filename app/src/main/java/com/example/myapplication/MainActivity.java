package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.myapplication.utils.Utils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Toolbar toolBarMain;
ViewFlipper viewFlipper;
RecyclerView recyclerViewMain;
NavigationView navigationView;
ListView listViewMain;
DrawerLayout  drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        addConstrols();
        ActionBar();
        ActionViewFlipper();
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://bloganchoi.com/wp-content/uploads/2023/11/z4871882713742-b36a85e4e6bc686fe2708bae7fb535b1.jpg");
        mangquangcao.add("https://images.squarespace-cdn.com/content/v1/52327cc4e4b0d03caffb90f7/1590991134736-L5YMLQ8DQTY8FFZWYCFK/POH_8958-min.jpg");
        mangquangcao.add("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhkPFTiTfKLRHO43wV1P-gtHkS43bycqYMngHhdY_5KF2xxyPRTavRHb8RJff9ymR_LPuwnNPqUmkfK7lP-uMQP8BxsniopmkhPvJVueLF2IMGK2SaPAHUWx2Za7MuJKwMoBmwUjVOHW3IRsku3F4ywA-GboEyIiGBe92LrspG8VG-n0r85G3qk0cnJeQ/s2725/Son%20D%C6%B0%E1%BB%A1ng%20Thu%E1%BA%A7n%20Chay%20Melixir%20Vegan%20Lip%20Butter%20%20C%C6%AFNG.VN_01.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolBarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarMain.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolBarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void addConstrols() {
        toolBarMain = findViewById(R.id.toolBarMain);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        navigationView = findViewById(R.id.navigationView);
        listViewMain = findViewById(R.id.listViewMain);
        drawerLayout = findViewById(R.id.drawerLayout);

        //thêm sp vào giỏ hàng: check giỏ hàng
        if(Utils.manggiohang == null) {
            Utils.manggiohang = new ArrayList<>();
        }


    }
}