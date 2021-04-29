package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView newsRecyclerView;
    RecyclerView.LayoutManager mLinearLayoutManager;
    RecyclerView.LayoutManager mGridLayoutManager;

    List<NewsItem> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView= findViewById(R.id.newsRecyclerView);

        mLinearLayoutManager= new LinearLayoutManager(this);
        mGridLayoutManager= new GridLayoutManager(this, 2);

        newsList= NewsListGenerator.generateList(30);
        NewsAdapter newsAdapter= new NewsAdapter(newsList);
        newsRecyclerView.setAdapter(newsAdapter);

        newsRecyclerView.setLayoutManager(mLinearLayoutManager);
    }
}