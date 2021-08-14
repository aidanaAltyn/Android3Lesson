package com.example.android3lesson1.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.android3lesson1.R;
import com.example.android3lesson1.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, HomeFragment.class,null).commit();
        }
    }
}