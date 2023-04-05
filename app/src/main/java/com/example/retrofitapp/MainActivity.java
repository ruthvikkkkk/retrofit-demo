package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofitapp.adapter.ProductDetailAdapter;
import com.example.retrofitapp.models.ProductDetails;
import com.example.retrofitapp.models.ProductsItem;
import com.example.retrofitapp.network.UserApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements ProductDetailAdapter.IProductDetailCommunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView textView = findViewById(R.id.product_recycler);
        MyApplication myApplication = (MyApplication) getApplication();
        RecyclerView recyclerView = findViewById(R.id.product_recycler);
        Button btShowImage = recyclerView.findViewById(R.id.bt_image);

        UserApiInterface userApiInterface = myApplication.retrofit.create(UserApiInterface.class);
        userApiInterface.getProductDetails(200).enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.i("RESPONSE", response.body().toString());
                    ProductDetails productDetails = response.body();
                    List<ProductsItem> productsItems = productDetails.getProducts();
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    recyclerView.setAdapter(new ProductDetailAdapter(productsItems, MainActivity.this));
//                    btShowImage.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            String imageURL = productsItems.get(0).getThumbnail();
//                            Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
//                            intent.putExtra("url", imageURL);
//                            startActivity(intent);
//                        }
//                    });
                    //textView.setText(response.body().toString());
                }else {
                    Log.i("FAIL", "couldn't retrieve data");
                    //textView.setText("couldn't get data");
                }
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {

            }
        });
    }

    @Override
    public void openImageActivity(String url) {
        Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}