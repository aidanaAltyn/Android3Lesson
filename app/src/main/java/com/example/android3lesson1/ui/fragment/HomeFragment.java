package com.example.android3lesson1.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson1.databinding.FragmentHomeBinding;
import com.example.android3lesson1.ui.adapter.ViewAdapter;
import com.example.android3lesson1.ui.model.MainViewModel;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ViewAdapter adapter;
    MainViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        adapter = new ViewAdapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();
        setupObserve();
        download();

    }

    private void download() {
        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupClickButton();
            }
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }
    private void setupRecycler() {
        binding.rv.setAdapter(adapter);
    }

    private void setupClickButton() {
        binding.btnDownload.setVisibility(View.GONE);
        viewModel.getBooks();
    }

    private void setupObserve() {
        viewModel.book.observe(getViewLifecycleOwner(), list -> {
            adapter.getList(list);
        });
    }







}