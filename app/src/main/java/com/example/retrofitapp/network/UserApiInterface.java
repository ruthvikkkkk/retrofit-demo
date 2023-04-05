package com.example.retrofitapp.network;

import com.example.retrofitapp.models.ProductDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApiInterface {
    @GET("products/")
    public Call<ProductDetails> getProductDetails(@Query("limit") int limit);
}