package com.liqiubo.example.demo.domain.clone;

public class Person {
    private String name;
    private int age;
    private String address;
    private String email;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .name("John")
                .age(25)
                .address("123 Main St")
                .email("john@example.com")
                .build();

        System.out.println(person.getName());     // 输出 "John"
        System.out.println(person.getAge());      // 输出 25
        System.out.println(person.getAddress());  // 输出 "123 Main St"
        System.out.println(person.getEmail());    // 输出 "john@example.com"
    }
}
