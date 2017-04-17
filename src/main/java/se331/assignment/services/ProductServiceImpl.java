package se331.assignment.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.assignment.dao.ProductDao;
import se331.assignment.entity.Product;

import java.util.List;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    public Product getProductById(long id) {
        return productDao.getProductById(id);
    }

    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }
}
