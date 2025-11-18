package com.codeit.jpastudy.chap01.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Product {

    private Long id;
    private String name;
    private int price;
    private Category category;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }

}
