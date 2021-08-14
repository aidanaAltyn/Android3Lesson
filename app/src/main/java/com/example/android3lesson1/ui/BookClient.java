package com.example.android3lesson1.ui;

import com.example.android3lesson1.R;
import com.example.android3lesson1.ui.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BookClient {
    List<Books> books = new ArrayList<>();
    public List<Books> getData(){
        books.add(new Books("Чистая Архитектура","jnfjnf", R.drawable.ic_launcher_foreground));
        books.add(new Books("Скорочтение","jfnjdf", R.drawable.ic_launcher_foreground));
        books.add(new Books("Маленький принц","Рассказ о принце", R.drawable.ic_launcher_foreground));
        books.add(new Books("Как научиться учиться", "exb",R.drawable.ic_launcher_foreground));
        books.add(new Books("Куринный бульон для души","Куринный бульон" ,R.drawable.ic_launcher_foreground));
        books.add(new Books("Гарри Потер","Гарри Потер", R.drawable.ic_launcher_foreground));
        return books;
    }
}
