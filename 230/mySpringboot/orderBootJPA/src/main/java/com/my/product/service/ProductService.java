package com.my.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.exception.FindException;
import com.my.product.repository.ProductRepository;
import com.my.product.vo.Product;

//@Component("pService")


@Service("pService")
public class ProductService {
	
	@Autowired
	private ProductRepository dao;
	
	public ProductService() {
		//dao = new ProductDAOOracle();
	}
	
	//@Autowired
	public ProductService( ProductRepository dao) {
		this.dao = dao;
		System.out.println("ProductService(" + dao + ")생성자호출됨");
	}	
	
	//@Autowired
	public void setDao( ProductRepository d) {
		this.dao = d;
		System.out.println("ProductService의 setDao(" + d +")호출됨");
	}
	
	public List<Product> findAll() throws FindException{
		return(List<Product>)dao.findAll();
//		Iterable<Product> iterableAll = dao.findAll();
//		List<Product> list = new ArrayList<>();
//		iterableAll.forEach(p-> list.add(p));
//		if(list.size() == 0) {
//			throw new FindException("상품이 없습니다");
//		}
		//return list;
		//return dao.findAll();
	}
	public Product findByNo(String prodNo) throws FindException{
		return dao.findById(prodNo).get();
	}
		//Optional<Product>optP = dao.findByProdNo(prodNo);
//		if(optP.isPresent()) {
//			return optP.get();
//		}else {
//			throw new FindException("상품이 없습니다");
//		}
//	}
//	public Iterable<Product> findByProdNoOrProdNameLike(String prodNo, String prodName, int prodPrice) throws FindException{
//		
//		//Iterator<Product> iterator = iterable.iterator();
//		return dao.findByProdNoOrProdNameLike(prodNo, prodName, prodPrice);
//	}
}
