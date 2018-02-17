package com.semarmesem.bidfish.bidfishcustomer.Model;

/**
 * Created by amaliaqis on 14/02/2018.
 */

public class User {

    String id;
    String name;
    String gender;
    String email;
    String address;
    String password;
    String phone;

    int  bidPrice;

    public User(){

    }

    public  User (User name, int bidPrice){
        this.name = String.valueOf(name);
        this.bidPrice = bidPrice;
    }

    public User(User name, User email, User address, User password, User phone){
        this.name = String.valueOf(name);
        this.email = String.valueOf(email);
        this.address = String.valueOf(address);
        this.password = String.valueOf(password);
        this.phone = String.valueOf(phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }
}

