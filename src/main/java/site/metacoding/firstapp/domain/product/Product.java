package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer productId;
    private String productName;
    private Integer productQTY;
    private Integer productPrice;
    private Timestamp createdAt;
}
