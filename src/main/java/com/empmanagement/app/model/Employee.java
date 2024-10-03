package com.empmanagement.app.model;

import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String post;

    public Employee(String name, String email, String department, String phone, String post) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.phone = phone;
        this.post = post;
    }

    public Employee() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
