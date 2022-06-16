package com.ghy.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
* 用户
* */
@Data
@ToString
@NoArgsConstructor
public class User {
    private String name;
    private String age;
    private Pet pet;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
