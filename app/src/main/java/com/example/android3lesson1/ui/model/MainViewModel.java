package com.example.android3lesson1.ui.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson1.R;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public MutableLiveData<ArrayList<Books>> book = new MutableLiveData<>();

    ArrayList<Books> list = new ArrayList<>();

//    public Books addList(int id){
//        return list.get(id);
//    }

    public void getBooks() {
        list.add(new Books("Чистая Архитектура", "Аннотация к книге " +
                "\"Чистая архитектура. Искусство разработки программного обеспечения\" \"Идеальный программист\" " + "и \"Чистый код\" - легендарные бестселлеры Роберта Мартина - рассказывают, как достичь высот профессионализма." +
                " ... Роберт Мартин дает прямые и лаконичные ответы на ключевые вопросы архитектуры и дизайна.",
                R.drawable.servis));
        list.add(new Books("Скорочтение", "Эта книга — тренажер, позволяющий каждому освоить скорочтение с помощью комплексной методики с запоминанием и хорошей концентрации при чтении."
                + " Скорости в современном мире сильно возросли, и эта книга — попытка автора уравнять " +
                "быстроту изменения мира и скорость вашего мышления для познания нововведений в этом мире",
                R.drawable.read));
        list.add(new Books("Маленький принц", " Сказка рассказывает о Маленьком принце, который посещает различные" +
                " планеты", R.drawable.picture));
        list.add(new Books("Как научиться учиться", "На протяжении долгого времени специалисты полагали что способность " +
                "к обучению — вопрос интеллекта, и в общем-то практически не изучали ее", R.drawable.book));
        list.add(new Books("Куринный бульон для души", "101 Лучшая история которая открывает сердце и исцеляет душу",
                R.drawable.cook));
        list.add(new Books("Гарри Потер", "Га́рри Джеймс По́ттер (англ. Harry James Potter) " +
                "литературный персонаж, главный герой серии романов английской " +
                "писательницы Джоан Роулинг", R.drawable.garri));
        book.setValue(list);
    }


}

