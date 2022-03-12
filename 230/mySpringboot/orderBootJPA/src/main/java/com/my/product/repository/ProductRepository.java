package com.my.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.my.product.vo.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

	//void findByProdNo(int i);
	//Iterable<Product> findByProdNoOrProdNameLike(String word, String word1);
	//Iterable<Product> findByProdNoOrProdNameOrProdPriceLike(String word, String word1,int num);

	

	//Optional<Product> findByProdNo(String prodNo);
	
	
	
}
