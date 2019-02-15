package com.rita.new_york_times.ui.fragments;

import com.rita.new_york_times.model.ArticlesResponse;
import com.rita.new_york_times.network.GetViewedService;
import com.rita.new_york_times.network.RetrofitClientInstance;

import retrofit2.Call;

public class FragmentViewed extends FragmentPopular {

    @Override
    public Call<ArticlesResponse> createCall() {
        GetViewedService service = RetrofitClientInstance.getRetrofitInstance().create(GetViewedService.class);
        return service.getArticles();
    }
}
