package com.example.retrofitapp.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductsItem{

	@SerializedName("discountPercentage")
	private Object discountPercentage;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("price")
	private int price;

	@SerializedName("rating")
	private Object rating;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("stock")
	private int stock;

	@SerializedName("category")
	private String category;

	@SerializedName("brand")
	private String brand;

	public void setDiscountPercentage(Object discountPercentage){
		this.discountPercentage = discountPercentage;
	}

	public Object getDiscountPercentage(){
		return discountPercentage;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setRating(Object rating){
		this.rating = rating;
	}

	public Object getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getStock(){
		return stock;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	@Override
 	public String toString(){
		return 
			"ProductsItem{" + 
			"discountPercentage = '" + discountPercentage + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",images = '" + images + '\'' + 
			",price = '" + price + '\'' + 
			",rating = '" + rating + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",stock = '" + stock + '\'' + 
			",category = '" + category + '\'' + 
			",brand = '" + brand + '\'' + 
			"}";
		}
}