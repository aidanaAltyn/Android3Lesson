package com.example.android3lesson1.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.android3lesson1.databinding.FragmentHomeBinding;
import com.example.android3lesson1.ui.adapter.ViewAdapter;
import com.example.android3lesson1.ui.model.Books;
import com.example.android3lesson1.ui.model.MainViewModel;
import com.example.android3lesson1.ui.model.OnClickListener;

import java.util.ArrayList;

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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupRecycler();
        setupObserve();
        download();
        setDataOnClick();
    }


    private void download() {
        binding.btnDownload.setOnClickListener(v -> {
            binding.btnDownload.setVisibility(View.GONE);
            viewModel.getBooks();
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }

    private void setupRecycler() {
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupObserve() {
        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnDownload.setVisibility(View.GONE);
                viewModel.getBooks();
            }
        });
            viewModel.book.observe(getViewLifecycleOwner(), new Observer<ArrayList<Books>>() {
                @Override
                public void onChanged(ArrayList<Books> books) {
                    binding.btnDownload.setVisibility(View.GONE);
                        adapter.getList(books);
                }
            });

    }

    private void setDataOnClick() {
        adapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onItemClick(int position, Books books, View view) {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(books).setGetModel(books));
            }
        });
    }


}