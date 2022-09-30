package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Integer productId;
    private String productName;
    private Integer productQTY;
    private Integer productPrice;
    private Timestamp createdAt;

    public Product(String string, int i, int j) {
    }

    // 여기 왜 프라이빗을 붙이는 거임?
    // 내가 실행할 일은 절대 없고 마이바티스 스라고 만들어진 애
    // 테스트 코드에서 실행하기 위해 만들었는데
    // no를 쓰면 개발자도 호출 가능하므로 private
    private Product() {
    }

}
