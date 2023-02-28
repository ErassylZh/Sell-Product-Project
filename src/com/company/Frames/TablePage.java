package com.company.Frames;

import com.company.DB.DataBase;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablePage extends Container {
    public JScrollPane scroll = new JScrollPane();
    public JTextArea table1 = new JTextArea();
    public JScrollPane scroll2=new JScrollPane();
    public JTextArea table2=new JTextArea();

    public TablePage(){
        setSize(700,500);
        setLayout(null);

        table1.setEditable(false);

        String str = "";
        for (int i = 0; i < DataBase.orders.size(); i++) {
            if (!DataBase.orders.get(i).isReady())
                str += DataBase.orders.get(i).print() + "\n" + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";
        }
        if(str.length()==0) str="No current Order";

        table1.setText(str);

        scroll=new JScrollPane(table1);
        scroll.setBounds(30,10, 300, 350);

        add(scroll);

        str="";
        for(int i=0;i<DataBase.orders.size();i++){
            if(DataBase.orders.get(i).isReady() && !DataBase.orders.get(i).isTake()){
                str += DataBase.orders.get(i).print() + "\n" + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";
            }
        }
        if(str.length()==0) str="No ready order!";
        table2.setEditable(false);
        table2.setText(str);
        scroll2=new JScrollPane(table2);
        scroll2.setBounds(350,10,300,350);
        add(scroll2);

        JButton exitButton=new JButton("exit");
        exitButton.setBounds(300,400,100,30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showStartPage();
            }
        });
        add(exitButton);
    }
    void update(){
        String str = "";
        for (int i = 0; i < DataBase.orders.size(); i++) {
            if (!DataBase.orders.get(i).isReady())
                str += DataBase.orders.get(i).print() + "\n" + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";
        }
        if(str.length()==0) str="No current Order";
        table1.setText(str);
        str="";
        for(int i=0;i<DataBase.orders.size();i++){
            if(DataBase.orders.get(i).isReady() && !DataBase.orders.get(i).isTake()){
                str += DataBase.orders.get(i).print() + "\n" + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";
            }
        }
        if(str.length()==0) str="No ready order!";
        table2.setText(str);
    }
}
