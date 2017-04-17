package se331.assignment.dao;

import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.assignment.entity.Product;
import se331.assignment.repository.ProductRepository;

import java.util.List;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
@Repository
public class ProductDaoDBImpl implements ProductDao {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        // return list
        // convert Iterable to List
        return Lists.newArrayList(productRepository.findAll());
    }

    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
