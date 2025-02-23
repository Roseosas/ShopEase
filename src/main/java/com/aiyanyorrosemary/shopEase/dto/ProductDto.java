package com.aiyanyorrosemary.shopEase.dto;

public class ProductDto {
    private String name;
    private String description;
    private String image;

    public ProductDto(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public ProductDto() {
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
