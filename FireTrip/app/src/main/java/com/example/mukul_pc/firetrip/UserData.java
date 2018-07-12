package com.example.mukul_pc.firetrip;

public class UserData {
    String user_id;
    String name;
    int age;

    public UserData() {

    }

    public UserData(String user_id, String name, int age) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
