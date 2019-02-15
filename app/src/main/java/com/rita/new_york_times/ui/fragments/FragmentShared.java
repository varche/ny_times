package com.rita.new_york_times.ui.fragments;

import com.rita.new_york_times.model.ArticlesResponse;
import com.rita.new_york_times.network.GetSharedService;
import com.rita.new_york_times.network.RetrofitClientInstance;

import retrofit2.Call;

public class FragmentShared extends FragmentPopular {
    @Override
    public Call<ArticlesResponse> createCall() {
        GetSharedService service = RetrofitClientInstance.getRetrofitInstance().create(GetSharedService.class);
        return service.getArticles();
    }
}
