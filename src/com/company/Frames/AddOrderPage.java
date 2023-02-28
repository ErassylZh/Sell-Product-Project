package com.company.Frames;

import com.company.*;
import com.company.DB.Client;
import com.company.DB.DataBase;
import com.company.DB.Order;
import com.company.DB.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddOrderPage extends Container {
    public JLabel clientLabel;
    public JComboBox clientsBox;
    public JLabel productLabel;
    public JComboBox productsBox;
    public JLabel res;
    public JLabel takedProducts;
    public JComboBox taked;
    public JButton delete;
    public JButton create;
    public JButton addButton;
    public JButton backButton;
    public JLabel alert;
    ArrayList<String> names=new ArrayList<>();
    public AddOrderPage(){
        setSize(700,500);
        setLayout(null);

        clientLabel=new JLabel("client");
        clientLabel.setBounds(50,50,100,30);
        add(clientLabel);

        String[] clientNames= new String[DataBase.clients.size()];
        int ind=0;
        for(Client client: DataBase.clients){
            clientNames[ind++]=client.getName();
        }

        clientsBox=new JComboBox(clientNames);
        clientsBox.setBounds(160,50,250,30);
        clientsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        add(clientsBox);

        productLabel=new JLabel("product");
        productLabel.setBounds(50,90,100,30);
        add(productLabel);

        String[] productNames= new String[DataBase.products.size()];
        ind=0;
        for(Product product: DataBase.products){
            productNames[ind++]=product.getName();
        }
        productsBox=new JComboBox(productNames);
        productsBox.setBounds(160,90,250,30);
        add(productsBox);

        addButton=new JButton("add to order");
        addButton.setBounds(430,90,150,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                names.add(String.valueOf(productsBox.getSelectedItem()));
                update();
            }
        });
        add(addButton);

        takedProducts=new JLabel("taked prods");
        takedProducts.setBounds(50,130,100,30);
        add(takedProducts);

        delete=new JButton("delete from order");
        delete.setBounds(430,130,150,30);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= (String) taked.getSelectedItem();
                names.remove(name);
                update();
            }
        });
        add(delete);

        taked=new JComboBox();
        taked.setBounds(160,130,250,30);
        add(taked);

        res=new JLabel("full price 0");
        res.setBounds(160,170,250,30);
        add(res);

        alert=new JLabel();
        alert.setBounds(160,250,190,30);
        add(alert);

        create=new JButton("create order");
        create.setBounds(160,210,130,30);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(names.size()==0){
                    alert.setText("please choice at least one product");
                }
                else {
                    for (Client client : DataBase.clients) {
                        if (clientsBox.getSelectedItem().equals(client.getName())) {
                            Order order = new Order(client);
                            for (String name : names) {
                                for (Product product : DataBase.products) {
                                    if (name.equals(product.getName())) {
                                        order.add(product);
                                        break;
                                    }
                                }
                            }
                            DataBase.addOrder(order);
                            break;
                        }
                    }
                    names.clear();
                    alert.setText("order created successfully");
                    update();
                    ;
                }
            }
        });
        add(create);

        backButton=new JButton("back");
        backButton.setBounds(160,280,130,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                names.clear();
                update();
                Main.showMenuPage();
            }
        });
        add(backButton);

    }
    void update(){

        double full=0,k=0.95;
        taked.removeAllItems();
        if(clientsBox.getSelectedItem().equals("NO USER")) k=1;
        for(String name:names){
            for(Product product:DataBase.products){
                if(name.equals(product.getName())) {
                    full += product.getPrice() * k;
                    break;
                }
            }
            taked.addItem(name);
        }
        res.setText("full price "+full);
        alert.setText("");

        productsBox.removeAllItems();
        for(Product product: DataBase.products){
         productsBox.addItem( product.getName());
        }
    }
}
