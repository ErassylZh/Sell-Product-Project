package com.company.Frames;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage extends Container {
    public MainMenuPage() {
        setSize(700,500);
        setLayout(null);

        JButton addOrderButton = new JButton("new order");
        JButton addClientButton = new JButton("new client");
        JButton listOfOrdersButton = new JButton("list of orders");
        JButton currentOrdersButton = new JButton("current orders");
        JButton addProduct = new JButton("add product");
        JButton exitButton = new JButton("exit");

        addOrderButton.setBounds(50,100,250,50);
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showAddOrderPage();
            }
        });
        add(addOrderButton);

        addClientButton.setBounds(320,100,250,50);
        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showAddClientPage();;
            }
        });
        add(addClientButton);

        listOfOrdersButton.setBounds(50,170,250,50);
        listOfOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showListOfOrdersPage();
            }
        });
        add(listOfOrdersButton);

        currentOrdersButton.setBounds(320,170,250,50);
        currentOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCurrentOrdersPage();
            }
        });
        add(currentOrdersButton);

        addProduct.setBounds(50,240,250,50);
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showAddProductPage();;
            }
        });
        add(addProduct);

        exitButton.setBounds(320,240,250,50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showStartPage();
            }
        });
        add(exitButton);
    }
}
