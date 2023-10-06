package com.example.kakao.order;

import java.util.List;
import java.util.stream.Collectors;
import com.example.kakao.cart.Cart;
import com.example.kakao.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderResponse {

    // (기능4) 주문상품 정보조회 (유저별)
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalprice;
        private List<CartDTO> carts;


        public FindAllByUserDTO(List<Cart> carts) {
            this.totalprice = 52800;
            this.carts =  carts.stream().map(c -> new CartDTO(c)).collect(Collectors.toList());
        }

        @Setter @Getter
        class CartDTO{
            private String name;
            private Integer quantity;
            private Integer price;
           
            
            public CartDTO( Cart cart) {
                this.name = cart.getOption().getProduct().getProductName()+" - "+ cart.getOption().getOptionName();
                this.quantity = cart.getQuantity();
                this.price = cart.getPrice();
            }
            
        }
        
    }
    // (기능5) 주문결과 확인
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {

    }
}
