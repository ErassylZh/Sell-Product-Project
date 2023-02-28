package com.company.DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Product> products=new ArrayList<>();
    public static ArrayList<Client> clients=new ArrayList<>();
    public static ArrayList<Order> orders=new ArrayList<>();
    public static ArrayList<Receipt> receipts=new ArrayList<>();
    static{
//        products.add(new Product("donut",390,100));
//        products.add(new Product("espresso",790,100));
//        products.add(new Product("americano",790,100));
//        products.add(new Product("latte",690,100));
//        products.add(new Product("cappuccino",690,100));
//        products.add(new Product("croissant",490,100));
//        products.add(new Product("sandwich",490,100));
//        products.add(new Product("cake",290,100));
//        products.add(new Product("cookies",790,100));
//        products.add(new Product("black Tea",690,100));
//        products.add(new Product("green Tea",690,100));
//        products.add(new Product("moroccan tea",690,100));
//        products.add(new Product("ginger tea",790,100));
//
//        clients.add(new Client("NO USER"));
//        clients.add(new Client("Naruto Uzumaki"));
//        clients.add(new Client("Sasuke Uchiha"));
//        clients.add(new Client("Sakura Haruno"));
//        clients.add(new Client("Kakashi Hatake"));
//        clients.add(new Client("Shikamaru Nara"));
//        clients.add(new Client("Choji Akimichi"));
//        clients.add(new Client("Ino Yamanaka"));
//        clients.add(new Client("Asuma Sarutobi"));
//        clients.add(new Client("Rock Lee"));
//        clients.add(new Client("Neji Hyuga"));
//
//        clients.add(new Client("Giyu Tomioka"));
//        clients.add(new Client("Sanemi Shinazugawa"));
//        clients.add(new Client("Shinobu Kocho"));
//        clients.add(new Client("Tengen Uzui"));
//        clients.add(new Client("Tanjiro Kamado"));
//        clients.add(new Client("Kanao Tsuyuri"));
//        clients.add(new Client("Zenitsu Agatsuma"));
//        clients.add(new Client("Inosuke Hashibira"));
//
//
//        Order order=new Order(clients.get(3));
//        order.add(products.get(0));
//        order.add(products.get(1));
//        order.add(products.get(0));
//        order.changeReadyStatus();
//        orders.add(order);
//        Order order1=new Order(clients.get(1));
//        order1.add(products.get(3));
//        order1.add(products.get(4));
//        orders.add(order1);
//        Order order2=new Order(clients.get(7));
//        order2.add(products.get(4));
//        orders.add(order2);
//        receipts.add(new Receipt(order));
//        receipts.add(new Receipt(order1));
//        receipts.add(new Receipt(order2));
//        System.out.println(orders);
//        saveClients();
//        saveOrders();
//        saveReceipts();
//        saveProducts();


        readOrders();
        readClients();
        readProducts();
        readReceipts();
    }
    public static void addOrder(Order order){
        orders.add(order);
        receipts.add(new Receipt(order));
        saveOrders();
        saveReceipts();
    }
    public static void addProduct(Product product) {
        for(Product pr:products){
            if(pr.getName().equals(product.getName())){
                pr.setCount(pr.getCount()+product.getCount());
                return;
            }
        }
        products.add(product);
        saveProducts();
    }

    public static void addClient(Client client) {
        clients.add(client);
        saveClients();
    }

    public static int contains(String name){
        for(Client client: clients){
            if(client.getName().equals(name)) return client.getId();
        }
        return -1;
    }

    public static int contains(Product product){
        int id=0;
        for(Product product1:products ){
            if(product.equals(product1)) return id;
            id++;
        }
        return -1;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }


    public static  void saveProducts(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("products.data"));
            outStream.writeObject(products);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveClients(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("clients.data"));
            outStream.writeObject(clients);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveOrders(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("orders.data"));
            outStream.writeObject(orders);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveReceipts(){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("receipts.data"));
            outStream.writeObject(receipts);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readProducts(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("products.data"));
            products = (ArrayList<Product>)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readClients(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("clients.data"));
            clients = (ArrayList<Client>)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readOrders(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("orders.data"));
            orders = (ArrayList<Order>)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readReceipts(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("receipts.data"));
            receipts = (ArrayList<Receipt>)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
