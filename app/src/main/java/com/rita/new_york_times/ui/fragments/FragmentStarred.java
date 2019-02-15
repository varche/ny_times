package com.rita.new_york_times.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.rita.new_york_times.db.AppDatabase;
import com.rita.new_york_times.model.ArticleEntity;
import com.rita.new_york_times.ui.recycler_adapters.AdapterStarred;
import com.rita.new_york_times.ui.recycler_adapters.RecyclerViewAdapter;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FragmentStarred extends FragmentArticle {

    List<ArticleEntity> articleList;

    public List<ArticleEntity> getArticleList() {
        return articleList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadData();

    }

    public void loadData() {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> {
            articleList = AppDatabase.getAppDatabase(getContext()).articleDAO().getAll();
            if (articleList.size() == 0)
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getContext(), "There is no starred article", Toast.LENGTH_SHORT).show();
                    }
                });
            else
                if (recyclerView != null)
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            setupRecyclerView();
                        }
                    });
        });
    }

    @Override
    protected void setupRecyclerView() {
        RecyclerViewAdapter recyclerViewAdapter = new AdapterStarred(getContext(), articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}

