package com.rana.loginandregister.database;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.List;

/**
 * Created by sandeeprana on 15/10/16.
 * License is only applicable to individuals and non-profits
 * and that any for-profit company must
 * purchase a different license, and create
 * a second commercial license of your
 * choosing for companies
 */

public class User extends SugarRecord {
    private String firstname;
    private String lastname;

    @Unique
    private String email;
    private String password;
    private String age;
    private String address;
    private String phone;

    public User(String email, String age, String password, String firstname, String lastname, String address, String phone) {

        this.email = email;
        this.age = age;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }

    public User() {

    }

    public static User getUser(String email, String password) {
        List<User> userList = User.find(User.class, " EMAIL=? AND PASSWORD=?", email, password);
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public static User getUser(String email) {
        List<User> userList = User.find(User.class, " EMAIL=?", email);
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
