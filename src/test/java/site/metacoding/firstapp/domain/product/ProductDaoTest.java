package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.firstapp.config.MyBatisConfig;

//@SpringBootTest 메모리에 모든 걸 다 띄우는 어노테이션
// http://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/
@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
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

    @Test
    public void findAll_test() {
        // given

        // when
        List<Product> productListPS = productDao.findAll();

        // then
        assertEquals(2, productListPS.size());
    }

    // junit은 메서드 실행직전에 트랜잭션이 걸리고, 메서드 실행이 끝나면 rollback됨

    // MyBatis는 resultset을 자바 엔티티로 변경할 때, 빈 생성자만 호출하고 세터가 없어도 값을 매핑해준다.
    // 마이바티스는 자바에서 db결과를 엔티티로 알아서 넣어주는 매퍼
    @Test
    public void inset_test() {
        // given
        Product product = new Product("수박", 1000, 100);
        // when
        productDao.insert(product);
        // then

        // mybatis insert 결과값 만들어내기 : usegeneratedkeys, keyproperty
        // dao에 result타입 없이 결과없이, get으로 꺼내 올 수 있음
        // key property에 컬럼명을 받으면, product엔 id가 없는데, insert가 완료되면 id를 찾아낼 수 있음

    }

    // config, mapping, 설정(db)

}
