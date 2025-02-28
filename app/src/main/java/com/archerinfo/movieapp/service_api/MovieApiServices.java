package com.archerinfo.movieapp.service_api;

import com.archerinfo.movieapp.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiServices {

    // Acts as a bridge between your app and the API

    // Call<ResponseType>: Represents a network request
    // and its response. 'ResponseType' should be replaced
    // with the actual data model class that represents
    // the expected response from the API.

    @GET("movie/popular")
    Call<Results> getPopularMovies(@Query("api_key") String apikey);

}
