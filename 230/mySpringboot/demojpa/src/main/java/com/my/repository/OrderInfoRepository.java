package com.my.repository;

import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.my.order.entity.OrderInfo;

public interface OrderInfoRepository extends CrudRepository<OrderInfo, Integer> {

}
