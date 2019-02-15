package com.rita.new_york_times.ui.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rita.new_york_times.R;

public abstract class FragmentArticle extends Fragment {

    protected RecyclerView recyclerView;
    ProgressDialog progressDialog;

    public FragmentArticle() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.article_fragment, container, false);
        recyclerView = view.findViewById(R.id.article_recycler_view);
        setupRecyclerView();
        return view;
    }

    protected abstract void setupRecyclerView();

}
