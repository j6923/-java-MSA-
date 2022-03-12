package com.my.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.my.customer.vo.Customer;
import com.my.order.vo.OrderInfo;

public interface OrderInfoRepository 
       extends CrudRepository<OrderInfo, Integer>{

	List<OrderInfo> findByOrderCustomer(Customer c);
}