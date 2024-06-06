package com.multidbs.springbootmdbs.productrepository;

import com.multidbs.springbootmdbs.productentity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}
