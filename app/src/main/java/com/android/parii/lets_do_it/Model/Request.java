package com.android.parii.lets_do_it.Model;

import java.util.List;

/**
 * Created by parii on 12/21/17.
 */

public class Request {
    private String phone,address,name,total;

    private List<Order> foods; //List of food Order

//

    public Request() {
    }

    public Request(String phone, String address, String name, String total, List<Order> foods) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        this.total = total;
        this.foods = foods;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
