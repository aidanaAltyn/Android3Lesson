package com.example.android3lesson1.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.android3lesson1.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}