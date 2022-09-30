package site.metacoding.firstapp.domain.product;

import java.util.List;

public interface ProductDao {
    public Product findById(Integer id);

    public List<Product> findAll();

    public void insert(Product product);

    public void update(Integer id, Product product);

    public void delete(Integer id);
}
