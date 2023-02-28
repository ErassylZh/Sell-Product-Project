package com.company.DB;

import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    private int id;
    public static int counter=1;
    private TreeMap<Product,Integer> products;
    private Client client;
    private boolean ready;
    private boolean take;
    public Order() {
    }

    public Order(Client client) {
        this.id = counter++;
        this.products=new TreeMap<>();
        this.client=client;
        take=false;
        ready=false;
    }

    public int getFullPrice() {
        int res=0;
        Product[] arr=  products.keySet().toArray(new Product[products.size()]);
        double k=0.95;
        if(client.getName().equals("NO USER")) k=1;
        for(int i=0;i<arr.length;i++){
            res+= arr[i].getPrice()*products.get(arr[i])*k;
        }
        return res;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", client=" + client +
                ", ready=" + ready +
                ", take=" + take +
                '}';
    }

    public String print(){
        String res="id=" + id +"\n"+"products:"+"\n";
        Product[] arr=  products.keySet().toArray(new Product[products.size()]);
        for(int i=0;i<arr.length;i++) res+=arr[i].getName()+" x"+products.get(arr[i])+"\n";
        res+=client;
        return res;
    }


    public String getListOfProduct() {
        String res="";
        for(Map.Entry<Product,Integer> entry:products.entrySet()){
            res+=entry.getKey().getName()+" "+entry.getKey().getPrice()+" * "+entry.getValue()+
                    " = "+entry.getKey().getPrice()*entry.getValue()+"\n";
        }
        return res;
    }

    public void add(Product product) {
        if(products.containsKey(product)){
            products.put(product,products.get(product)+1);
        }
        else products.put(product, 1);

    }

    void changeReadyStatus(){
        ready=true;
        DataBase.saveOrders();
    }

    void changeTakeStatus(){
        take=true;
        DataBase.saveOrders();
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isTake() {
        return take;
    }
}
