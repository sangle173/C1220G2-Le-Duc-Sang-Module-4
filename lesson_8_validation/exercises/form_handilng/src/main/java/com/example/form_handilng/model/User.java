package com.example.form_handilng.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 3, max = 50, message = "The name must be 3 to 50 char")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String gender;
    @Size(max = 100)
    private String note;
    @NotBlank
    private String profession;
    @AssertFalse
    private boolean married;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String birthday;

    public User() {
    }

    public User(String name, String email, String password, String gender, String note, String profession, boolean married, String birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.note = note;
        this.profession = profession;
        this.married = married;
        this.birthday = birthday;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
