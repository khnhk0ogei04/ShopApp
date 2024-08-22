package com.project.shopapp.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value=1, message = "Order's id must be > 0")
    private long orderId;

    @JsonProperty("product_id")
    @Min(value=1, message = "Product_id must be > 0")
    private long productId;

    @Min(value=0, message = "Price must be >= 0")
    private long price;

    @Min(value=1, message = "Nums of products must be >= 1")
    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @Min(value=0, message = "Total price must be >= 0")
    @JsonProperty("total_money")
    private int totalMoney;

    private String color;
}
