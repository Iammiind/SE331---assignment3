package se331.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.assignment.dao.ProductDao;
import se331.assignment.entity.Product;

/**
 * Created by iammiind on 4/17/2017 AD.
 */
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ProductDao productDao;

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Product product1 = Product.builder().name("Happy Farm Book").description("แป๋วเทรลเล่อร์เกมส์ลาเต้อ่อนด้อย ฮาลาลอ่อนด้อยไชน่าบอร์ด").picture("-1dba1a0a3c858b09.jpg")
                .price(150).amount(10).rating(7.7).build();
        Product product2 = Product.builder().name("Moomin Pen").description("moomin moomin").picture("-3f50e06e-217c451b.jpeg")
                .price(60).amount(20).rating(9.9).build();

        productDao.addProduct(product1);
        productDao.addProduct(product2);

    }
}
