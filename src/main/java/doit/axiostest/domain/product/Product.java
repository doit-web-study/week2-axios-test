package doit.axiostest.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="product_id")
    private Long id;

    private String title;
    private String content;
    private int price;

    @Builder
    private Product(String content, String title, int price) {
        this.content = content;
        this.title = title;
        this.price = price;
    }

    public static Product create(String title, String content, int price) {
        return Product.builder()
                .title(title)
                .content(content)
                .price(price)
                .build();
    }
}
