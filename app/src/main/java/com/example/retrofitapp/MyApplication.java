package com.example.retrofitapp;

import android.app.Application;

import com.example.retrofitapp.network.UserApiInterface;
import com.example.retrofitapp.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    Retrofit retrofit;

    @Override
    public void onCreate() {

        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.HOST)
                .build();
        super.onCreate();
    }
}
