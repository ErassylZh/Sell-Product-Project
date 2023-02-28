package com.company.DB;

import java.io.Serializable;
import java.util.Date;

public class Receipt implements Serializable {
    private int id;
    private Order order;
    private int full;
    private Date currentTime;
    private static int count=1;
    public Receipt(Order order) {
        this.id=count++;
        this.order = order;
        currentTime=new Date();
        full=order.getFullPrice();
    }

    @Override
    public String toString() {
        return "order id=" + id +"\n"+
                "ordered by: "+order.getClient().getName()+"\n"+
                "list of products: " +"\n"+ order.getListOfProduct() +"_________________________"+"\n"+
                "full price=" + full +"\n"+
                "order Time:  " + currentTime +"\n"+
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n";

    }

    public Order getOrder() {
        return order;
    }

    public int getFull() {
        return full;
    }

    public Date getCurrentTime() {
        return currentTime;
    }
}
