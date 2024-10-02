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

    private String name;
    private String content;
    private int price;

    @Builder
    private Product(String content, String name, int price) {
        this.content = content;
        this.name = name;
        this.price = price;
    }

    public static Product create(String name, String content, int price) {
        return Product.builder()
                .name(name)
                .content(content)
                .price(price)
                .build();
    }
}
