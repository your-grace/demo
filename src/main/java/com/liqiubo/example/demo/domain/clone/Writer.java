package com.liqiubo.example.demo.domain.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
@Data
@AllArgsConstructor
public class Writer implements Serializable {
    private int age;
    private String name;
    private Book book;

    // getter/setter 和构造方法都已省略

    public Writer(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString().substring(26) +
                " age=" + age +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }

    //深度拷贝
    public Object deepClone() throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }
}
