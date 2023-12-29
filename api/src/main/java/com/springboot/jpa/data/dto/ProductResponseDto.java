package com.springboot.jpa.data.dto;

public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    public static ProductResponseDtoBuilder builder() {
        return new ProductResponseDtoBuilder();
    }

    public static class ProductResponseDtoBuilder {
        private Long number;
        private String name;
        private int price;
        private int stock;

        ProductResponseDtoBuilder() {

        }

        public ProductResponseDtoBuilder number(Long number) {
            this.number = number;
            return this;
        }

        public ProductResponseDtoBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ProductResponseDtoBuilder name (String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDtoBuilder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public ProductResponseDto build() {
            return new ProductResponseDto (number, name, stock, price);
        }

        public String toString () {
            return "ProductResponseDto.ProductResponseDtoBuilder(number=" + this.number +
                    ", name = " + this.name + ",price=" + this.price + ", stock =" + this.stock + ")";
        }

    }
    public ProductResponseDto() {}

    public ProductResponseDto(Long number, String name, int stock, int price){
        this.stock = stock;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
