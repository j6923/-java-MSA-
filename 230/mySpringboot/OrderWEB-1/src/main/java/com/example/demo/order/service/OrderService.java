package com.example.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AddException;
import com.example.demo.exception.FindException;
import com.example.demo.order.dao.OrderDAOInterface;
import com.example.demo.order.vo.OrderInfo;

@Service("oService")
public class OrderService {
	@Autowired
	private OrderDAOInterface dao;
	public void add(OrderInfo info) throws AddException{
		dao.add(info);
	}
	public List<OrderInfo> findById(String orderId) throws FindException{
		System.out.println("in ordeservice dao=" + dao);
		return dao.findById(orderId);
	}
}
