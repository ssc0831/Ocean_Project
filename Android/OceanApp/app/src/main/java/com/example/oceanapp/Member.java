package com.example.oceanapp;

public class Member {

    private Long id;
    private String name;
    private String tel;
    private String password;
    private String email;

    public Member() {
    }

    public Member(String tel, String password) {
        this.tel = tel;
        this.password = password;
    }

    public Member(Long id, String name, String tel, String password, String email, Boolean lockset, String locknum) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.email = email;
    }

    public Member(String name, String tel, String password, String email) {
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


