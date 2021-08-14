package com.example.android3lesson1.ui.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson1.R;
import com.example.android3lesson1.ui.BookClient;
import com.example.android3lesson1.ui.model.Books;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
 private final BookClient bookClient = new BookClient();

   public  MutableLiveData<List<Books>> book = new MutableLiveData<>();
    public void getBooks() {
       book.setValue(bookClient.getData());
    }
}

