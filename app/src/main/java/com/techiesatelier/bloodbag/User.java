package com.techiesatelier.bloodbag;

public class User {
    String name,age,phone,email,group,city;

    public User() {
    }

    public User(String name, String age, String phone, String email, String group, String city) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.group = group;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
