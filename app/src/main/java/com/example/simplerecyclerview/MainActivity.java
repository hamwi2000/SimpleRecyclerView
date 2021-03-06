package com.example.simplerecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView newsRecyclerView;
    RecyclerView.LayoutManager mLinearLayoutManager;
    RecyclerView.LayoutManager mGridLayoutManager;

    List<NewsItem> newsList;

    Menu ListGridMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecyclerView = findViewById(R.id.newsRecyclerView);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 2);

        newsList = NewsListGenerator.generateList(30);
        NewsAdapter newsAdapter = new NewsAdapter(newsList, new OnListItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemSelected(position);
            }
        });
        newsRecyclerView.setAdapter(newsAdapter);

        newsRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.ListGridMenu = menu;
        getMenuInflater().inflate(R.menu.menu_list_grid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_grid;
                newsRecyclerView.setLayoutManager(mGridLayoutManager);
                item.setVisible(false);
                ListGridMenu.findItem(R.id.action_list).setVisible(true);
                return true;

            case R.id.action_list;
                newsRecyclerView.setLayoutManager(mLinearLayoutManager);
                item.setVisible(false);
                ListGridMenu.findItem(R.id.action_grid).setVisible(true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void itemSelected(int position) {
        NewsItem selectedItem= newsList.get(position);
        String message= "?????? ?????????? ?????????? ??????" + position + "?????? ?????????? ?????? ??????????????" + selectedItem.getTitle();

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}