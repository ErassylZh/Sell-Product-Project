package com.company.Frames;

import com.company.DB.DataBase;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListOfOrdersPage extends Container {
    public JScrollPane scroll = new JScrollPane();
    public JTextArea table1 = new JTextArea();
    public JButton button;
    public ListOfOrdersPage(){
        setSize(700,500);
        setLayout(null);

        String text="";
        for(int i = 0; i< DataBase.receipts.size(); i++){
            text+=DataBase.receipts.get(i) +"\n"+"\n";
        }
        table1.setText(text);
        scroll=new JScrollPane(table1);
        scroll.setBounds(50,50,500,400);
        add(scroll);

        button=new JButton("back");
        button.setBounds(250,15,100,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showMenuPage();;
            }
        });
        add(button);
    }
    void update(){
        String text="";
        for(int i=0;i<DataBase.receipts.size();i++){
            text+=DataBase.receipts.get(i) +"\n"+"\n";
        }
        table1.setText(text);
    }
}
