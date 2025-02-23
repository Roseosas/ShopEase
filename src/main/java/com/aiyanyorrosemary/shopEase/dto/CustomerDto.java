package com.aiyanyorrosemary.shopEase.dto;

public class CustomerDto {
private String name;
private String email;

public CustomerDto (String name, String email){
    this.name= name;
    this.email = email;
}
public CustomerDto() {

}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
