package se331.assignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se331.assignment.entity.Product;

/**
 * Created by iammiind on 4/16/2017 AD.
 */

public interface ProductRepository extends CrudRepository<Product, Long>{
    Product getProductById(Long id);
}
