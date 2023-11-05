package com.example.FoodApi.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.FoodApi.model.Product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
public class ProductJson {
	private long id;
	private String productName;
	private int price;
	private LocalDateTime createAt;
	private String image;
    public static ProductJson packJson(Product product){
        ProductJson json = new ProductJson();
		json.setId(product.getId());
		json.setProductName(product.getName());
		json.setCreateAt(product.getCreateAt());
		json.setPrice(product.getPrice());
		json.setImage(product.getImage());
        return json;
    }
    public static List<ProductJson> packJsons(List<Product> products) {
		List<ProductJson> jsons = new ArrayList<>();
		for (Product product : products) {
			jsons.add(ProductJson.packJson(product));
		}
		return jsons;
	}
}
