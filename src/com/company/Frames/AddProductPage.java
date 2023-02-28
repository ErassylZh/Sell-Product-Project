package com.company.Frames;

import com.company.DB.DataBase;
import com.company.Main;
import com.company.DB.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductPage extends Container {
    public JTextField nameField;
    public JTextField priceField;
    public JTextField countField;
    public JLabel nameLabel;
    public JLabel priceLabel;
    public JLabel countLabel;
    public JButton addButton;
    public JButton backButton;
    public AddProductPage(){
        setSize(700,500);
        setLayout(null);

        nameLabel=new JLabel("name ");
        nameLabel.setBounds(50,50,100,30);
        add(nameLabel);

        priceLabel=new JLabel("price");
        priceLabel.setBounds(50,100,100,30);
        add(priceLabel);

        countLabel=new JLabel("count");
        countLabel.setBounds(50,150,100,30);
        add(countLabel);

        nameField=new JTextField();
        nameField.setBounds(160,50,100,30);
        add(nameField);

        priceField=new JTextField();
        priceField.setBounds(160,100,100,30);
        add(priceField);


        countField=new JTextField();
        countField.setBounds(160,150,100,30);
        add(countField);

        addButton=new JButton("add");
        addButton.setBounds(100,200,100,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                DataBase.addProduct(new Product(name,price,count));
                nameField.setText("");
                countField.setText("");
                priceField.setText("");
            }
        });
        add(addButton);

        backButton=new JButton("back");
        backButton.setBounds(100,250,100,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showMenuPage();
            }
        });
        add(backButton);
    }
}

