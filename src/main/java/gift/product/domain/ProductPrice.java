package gift.product.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import gift.product.exception.ProductPriceOutOfRangeException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ProductPrice {

    @Column(name = "price")
    private Long value;

    public ProductPrice() {}

    public ProductPrice(Long value) {
        if (value < 0) {
            throw new ProductPriceOutOfRangeException();
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

    // JSON 직렬화를 위해 @JsonValue 사용
    @JsonValue
    public Long toJson() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
