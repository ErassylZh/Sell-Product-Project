package com.company.Frames;

import com.company.DB.Client;
import com.company.DB.DataBase;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientPage extends Container {
    public JTextField nameField;
    public JLabel nameLabel;
    public JButton addButton;
    public JButton backButton;
    public JLabel alert;
    public AddClientPage(){
        setSize(700,500);
        setLayout(null);
        nameLabel=new JLabel("name ");
        nameLabel.setBounds(150,150,100,30);
        add(nameLabel);

        nameField=new JTextField();
        nameField.setBounds(200,150,200,30);
        add(nameField);

        alert=new JLabel();
        alert.setBounds(200,230,300,50);
        add(alert);

        addButton=new JButton("add");
        addButton.setBounds(200,190,100,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                if(DataBase.contains(name)!=-1){
                    alert.setText("A client with this name already exists");
                }
                else {
                    DataBase.addClient(new Client(name));
                    nameField.setText("");
                    alert.setText("client added successfully");
                }
            }
        });
        add(addButton);

        backButton=new JButton("back");
        backButton.setBounds(320,190,100,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showMenuPage();
            }
        });
        add(backButton);
    }
}
