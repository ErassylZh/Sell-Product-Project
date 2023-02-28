package com.company.DB;

import java.io.Serializable;
import java.util.TreeMap;

public class Client implements Serializable {
    private int id;
    private String name;
    private static int counter=0;
    private int countOfOrders=0;
    public Client( String name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
