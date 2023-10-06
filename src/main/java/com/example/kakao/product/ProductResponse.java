package com.example.kakao.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private int id;
        private String productName;
        private String image;
        private int price;

        public FindAllDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();
        }

        
    }

    // (기능2) 상품 상세보기
    @Getter
    @Setter
    public static class FindByIdDTO {
        private int id;
        private String productName;
        private String image;
        private int price;
        private int startCount;
        private List<OptionDTO> options;
        
        public FindByIdDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();
            this.startCount = 4;
            this.options = product.getOptions().stream().map(option -> new OptionDTO(option)).collect(Collectors.toList());

        }

        @Getter
        @Setter
        class OptionDTO {
            private int id;
            private String optionName;
            private int price;

            public OptionDTO(Option option) {
                this.id = option.getId();
                this.optionName = option.getOptionName();
                this.price = option.getPrice();
            }

        }

    }
}