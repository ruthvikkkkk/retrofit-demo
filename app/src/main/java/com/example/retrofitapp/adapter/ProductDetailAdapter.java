package com.example.retrofitapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.R;
import com.example.retrofitapp.models.ProductDetails;
import com.example.retrofitapp.models.ProductsItem;

import java.util.List;

public class ProductDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    IProductDetailCommunicator mIProductDetailCommunicator;
    public List<ProductsItem> products;

    public ProductDetailAdapter(List<ProductsItem> products, IProductDetailCommunicator communicator){
        this.products = products;
        mIProductDetailCommunicator = communicator;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_details, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductsItem productsItem = products.get(position);
        ((ProductViewHolder) holder).productBind(productsItem);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        View view;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            view.findViewById(R.id.bt_image).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1) {
                        mIProductDetailCommunicator.openImageActivity(products.get(getAdapterPosition()).getThumbnail());
                    }
                }
            });
        }

        public void productBind(ProductsItem productsItem){
            ((TextView)view.findViewById(R.id.tv_name1)).setText(productsItem.getTitle());
            ((TextView)view.findViewById(R.id.tv_price1)).setText(productsItem.getPrice()+"");
            ((TextView)view.findViewById(R.id.tv_review1)).setText(productsItem.getRating().toString());
            ((TextView)view.findViewById(R.id.tv_count)).setText(getAdapterPosition()+1+"");
        }
    }

    public interface IProductDetailCommunicator {
        void openImageActivity(String url);
    }
}
