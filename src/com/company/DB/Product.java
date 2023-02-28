package com.company.DB;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {
    private String name;
    private int price;
    private  int count;
    public Product(String name, int price,int count) {
        this.name = name;
        this.price = price;
        this.count=count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void sell(){
        count--;
    }
    public  void sell(int num){
        count=count-num;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }


}
