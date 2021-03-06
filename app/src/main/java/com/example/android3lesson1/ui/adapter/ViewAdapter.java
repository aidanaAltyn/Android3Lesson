package com.example.android3lesson1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.R;
import com.example.android3lesson1.ui.model.Books;
import com.example.android3lesson1.ui.model.OnClickListener;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

     ArrayList<Books> list = new ArrayList<>();
     OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void getList(ArrayList<Books> addList){
        this.list = addList;
        notifyDataSetChanged();
    }

    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_txt);
            imageView = itemView.findViewById(R.id.item_image);
        }

        public void bind(Books books) {
            title.setText(books.getTitle());
            imageView.setImageResource(books.getImage());
            itemView.setOnClickListener(v -> {
                onClickListener.onItemClick(getAdapterPosition(),books, v);
            });
        }
    }
}
