package com.example.android3lesson1.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson1.databinding.FragmentDetailBinding;
import com.example.android3lesson1.ui.model.Books;
import com.example.android3lesson1.ui.model.MainViewModel;

public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDesc();
        getDataModel();
    }

    private void getDataModel() {
        Books books =  DetailFragmentArgs.fromBundle(getArguments()).getGetModel();
        binding.image.setImageResource(books.getImage());
        binding.item.setText(books.getTitle());
        binding.des.setText(books.getDesc());

    }

    private void getDesc() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }


}