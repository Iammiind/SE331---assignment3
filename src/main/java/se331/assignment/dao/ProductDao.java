package se331.assignment.dao;

import se331.assignment.entity.Product;

import java.util.List;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
public interface ProductDao {
    List<Product> getAllProduct();
    Product getProductById(long id);
    Product addProduct(Product product);
}
