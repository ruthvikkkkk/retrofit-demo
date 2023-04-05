package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.retrofitapp.network.UserApiInterface;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(getApplicationContext()).load(url).into(imageView);
    }
}