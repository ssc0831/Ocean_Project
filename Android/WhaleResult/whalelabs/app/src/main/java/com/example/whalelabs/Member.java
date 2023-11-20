package com.example.whalelabs;

public class Member {

    private Long id;
    private String name;
    private String tel;
    private String password;
    private String email;
    private String profileImg;

    public Member() {
    }

    public Member(String tel, String password) {
        this.tel = tel;
        this.password = password;
    }

    public Member(Long id, String name, String tel, String password, String email, String profileImg) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.email = email;
        this.profileImg = profileImg;
    }

    public Member(String name, String tel, String password, String email) {
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.email = email;
    }

    public Member(String name, String tel, String email, String password, String profileImg) {
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

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}


