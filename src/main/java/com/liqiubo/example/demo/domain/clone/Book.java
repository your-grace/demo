package com.liqiubo.example.demo.domain.clone;

import lombok.Data;

import java.io.Serializable;
@Data
public class Book implements Serializable {
    private String bookName;
    private int price;

    // getter/setter 和构造方法都已省略

    public Book(String bookName, int price) {
        this.bookName = bookName;
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString().substring(26) +
                " bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }
}
