package com.my.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.my.customer.vo.Customer;
import com.my.product.vo.Product;

public interface CustomerRepository extends CrudRepository<Customer, String> {
//	List<Customer> insert(String id1, String pwd1, String name1, String adderess1);
}
