package com.rita.new_york_times.ui.fragments;

import com.rita.new_york_times.model.ArticlesResponse;
import com.rita.new_york_times.network.GetEmailedService;
import com.rita.new_york_times.network.RetrofitClientInstance;

import retrofit2.Call;

public class FragmentEmailed extends FragmentPopular {


    @Override
    public Call<ArticlesResponse> createCall() {
        GetEmailedService service = RetrofitClientInstance.getRetrofitInstance().create(GetEmailedService.class);
        return service.getArticles();
    }
}
