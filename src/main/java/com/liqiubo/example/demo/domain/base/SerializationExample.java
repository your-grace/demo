package com.liqiubo.example.demo.domain.base;

import java.io.*;

/**
 * 序列化（Serialization）是将对象转换为字节流的过程，以便将其存储在磁盘、通过网络传输或在内存中进行持久化。
 * 反序列化（Deserialization）则是将字节流转换回对象的过程。
 * 序列化和反序列化的主要目的是实现对象的持久化和跨网络传输。通过序列化，我们可以将对象转换为字节流，然后将其保存到文件或数据库中。
 * 而反序列化则可以将存储的字节流重新转换为对象，使其重新恢复到内存中。
 * Java中的序列化和反序列化可以通过实现 Serializable 接口来实现。
 * 该接口是一个标记接口，没有任何方法，只是用于标识类的对象可以被序列化。
 */
public class SerializationExample {
    public static void main(String[] args) {
        // 创建一个对象
        Person person = new Person("John", 25);

        // 序列化对象
        try {
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("对象已被序列化并保存到 person.ser 文件");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化对象
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("从 person.ser 文件中反序列化对象：" + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// 实现 Serializable 接口
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
