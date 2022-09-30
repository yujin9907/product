package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        // given : 변수로 받는 걸로 통일
        Integer id = 1;

        String name = "수박";
        Integer price = 1000;
        Integer qty = 100;

        Product product = new Product(name, price, qty);
        // when
        int result = productDao.insert(product);
        // then

        // mybatis insert 결과값 만들어내기 : usegeneratedkeys, keyproperty
        // dao에 result타입 없이 결과없이, get으로 꺼내 올 수 있음
        // key property에 컬럼명을 받으면, product엔 id가 없는데, insert가 완료되면 id를 찾아낼 수 있음
        System.out.println(result);
        assertEquals(id, result);
    }

    @Test
    public void update_test() {
        // given : new 생성자 ㄴㄴ 업데이트-영속화해서 db에 있는지 확인 먼저하고 해야됨(트랜잭션 범위 최소화를 위해)
        Integer productId = 1; // 기븐 데이터
        String name = "수박";
        Integer price = 1000;
        Integer qty = 100;
        // 클라이언트한테 받을 값, id 빼고
        Product product = new Product(name, price, qty);
        product.setProductId(productId);

        // verify
        Product productPS = productDao.findById(product.getProductId());
        // 영속화 검증 먼저
        // if (product == null) {
        // System.out.println("update_test() : 해당상품 ㄴㄴ"); // 디버그 콘솔 필터 이용해서 함수명 검색
        // } else {
        // System.out.println("update_test() : 상품 있음");
        // } 이것보단 어설트트루를 통해 검증
        assertTrue(product == null ? false : true);

        // when
        // 1, 바나나, 300, 98
        productPS.update(product); // id를 같이 넣어주는 대신 직접 객체를 만들어서 넣어줌
        // 수박, 1000, 100
        int result = productDao.update(productPS);

        // then
        assertEquals(1, result);
    }

    @Test
    public void delete_test() {
        // given : 데이터 주고 검증
        Integer id = 1;
        Product productPS = productDao.findById(id);
        assertTrue(productPS == null ? false : true);

        // when : delete 실행
        // productDao.deleteById(id);
        // Product result = productDao.findById(id);

        int result = productDao.deleteById(id);

        // then : 결과 확인
        assertEquals(1, result);
    }

    // 안전한 코드=검증(영속화를 통해) 먼저=슬데없는 io를 최대한 줄이는 것
    // 오류 : config, mapping, 설정(db)

}
