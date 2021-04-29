package com.example.simplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    List<NewsItem> newsList;
    OnListItemClickListener onListItemClickListener;

    public NewsAdapter(List<NewsItem> itemList, OnListItemClickListener onListItemClickListener) {
        newsList= itemList;
        this.onListItemClickListener= onListItemClickListener;
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_news, parent, false);
        NewsViewHolder newsViewHolder= new NewsViewHolder(view, onListItemClickListener);

        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem= newsList.get(position);
        holder.titleTv.setText(newsItem.getTitle());
        holder.subtitleTv.setText(newsItem.getSubtitle());

        holder.position= position;

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        int position;
        TextView titleTv;
        TextView subtitleTv;

        NewsViewHolder(View itemView, OnListItemClickListener onListItemClickListener) {
            super(itemView);
            titleTv= itemView.findViewById(R.id.text_view_title);
            subtitleTv= itemView.findViewById(R.id.text_view_subtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListItemClickListener.onItemClick(position);
                }
            });
        }
    }
}
