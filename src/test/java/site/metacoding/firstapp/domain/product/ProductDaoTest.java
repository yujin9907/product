package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest 메모리에 모든 걸 다 띄우는 어노테이션

public class ProductDaoTest {

    // 테스트는 빈 생성자만 new 하기 때문에 어노테이션으로 주입
    @Autowired
    private ProductDao productDao;

    @Test
    public void findById_test() {
        // given
        Integer productId = 1;

        // when
        Product productPS = productDao.findById(productId);

        // then
        assertEquals("바나나", productPS.getProductName());
        // true 될때까지 테스트해야 됨
    }

}
