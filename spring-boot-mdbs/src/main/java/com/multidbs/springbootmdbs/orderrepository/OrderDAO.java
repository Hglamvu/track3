package com.multidbs.springbootmdbs.orderrepository;

import com.multidbs.springbootmdbs.orderentity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Integer> {

}
