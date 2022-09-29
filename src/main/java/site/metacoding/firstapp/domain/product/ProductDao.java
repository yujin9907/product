package site.metacoding.firstapp.domain.product;

import java.util.List;

public interface ProductDao {
    Product findById(Integer id);

    List<Product> findAll();

    void insert(Product product);

    void update(Integer id, Product product);

    void delete(Integer id);
}
