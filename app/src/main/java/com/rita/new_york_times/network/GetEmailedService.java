package com.rita.new_york_times.network;

import com.rita.new_york_times.model.ArticlesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEmailedService {
    @GET("/svc/mostpopular/v2/emailed/30.json?api-key=GPBCi3qqNMklj07reeGRzwxnH532IBEo")
    Call<ArticlesResponse> getArticles();
}
