package site.metacoding.firstapp.domain.product;

import java.util.List;

public interface ProductDao {
    public Product findById(Integer id);

    public List<Product> findAll();

    public int insert(Product product);

    public int update(Product product);

    public int deleteById(Integer id);
}
