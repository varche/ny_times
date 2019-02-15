package com.rita.new_york_times.ui.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.rita.new_york_times.model.ArticleJSON;
import com.rita.new_york_times.model.ArticlesResponse;
import com.rita.new_york_times.ui.recycler_adapters.AdapterPopular;
import com.rita.new_york_times.ui.recycler_adapters.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class FragmentPopular extends FragmentArticle {

    protected List<ArticleJSON> articleList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<ArticlesResponse> call = createCall();
        call.enqueue(new Callback<ArticlesResponse>() {
            @Override
            public void onResponse(Call<ArticlesResponse> call, Response<ArticlesResponse> response) {
                progressDialog.dismiss();
                articleList = response.body().getResults();

                if (recyclerView != null)
                    setupRecyclerView();
            }

            @Override
            public void onFailure(Call<ArticlesResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Cannot get articles now", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected abstract Call<ArticlesResponse> createCall();

    @Override
    protected void setupRecyclerView() {
        RecyclerViewAdapter recyclerViewAdapter = new AdapterPopular(getContext(), articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
