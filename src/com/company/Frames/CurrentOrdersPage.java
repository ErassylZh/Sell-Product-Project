package com.company.Frames;

import com.company.DB.DataBase;
import com.company.Main;
import com.company.DB.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentOrdersPage extends Container {
    public JScrollPane scroll = new JScrollPane();
    public JTextArea table1 = new JTextArea();
    public JScrollPane scroll2=new JScrollPane();
    public JTextArea table2=new JTextArea();
    public JComboBox forCurrent;
    public JComboBox forReady;
    public JButton toReadyButton;
    public JButton toTakeButton;
    public String[] currentOrdersId;
    public String[] readyOrdersId;
    public CurrentOrdersPage(){
        setSize(700,500);
        setLayout(null);

        table1.setEditable(false);
        String str = "";
        int ind=0;
        for (int i = 0; i < DataBase.orders.size(); i++) {
            if (!DataBase.orders.get(i).isReady()) {
                str += DataBase.orders.get(i).print() + "\n"+DataBase.orders.get(i).getFullPrice()  + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";

                ind++;
            }
        }
        currentOrdersId=new String[ind];
        ind=0;
        for (int i = 0; i < DataBase.orders.size(); i++) {
            if (!DataBase.orders.get(i).isReady())
                currentOrdersId[ind++] = String.valueOf(DataBase.orders.get(i).getId());
        }
        if(str.length()==0) str="No current Order";

        table1.setText(str);

        scroll=new JScrollPane(table1);
        scroll.setBounds(30,10, 300, 300);
        add(scroll);

        str=""; ind=0;
        for(int i=0;i<DataBase.orders.size();i++){
            if(DataBase.orders.get(i).isReady() && !DataBase.orders.get(i).isTake()){
                str += DataBase.orders.get(i).print() + "\n" +DataBase.orders.get(i).getFullPrice() + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";

                ind++;
            }
        }
        readyOrdersId=new String[ind];
        ind=0;
        for(int i=0;i<DataBase.orders.size();i++){
            if(DataBase.orders.get(i).isReady() && !DataBase.orders.get(i).isTake()){
                readyOrdersId[ind++]=String.valueOf(DataBase.orders.get(i).getId());
            }
        }
        if(str.length()==0) str="No ready order!";
        table2.setEditable(false);
        table2.setText(str);

        scroll2=new JScrollPane(table2);
        scroll2.setBounds(350,10,300,300);
        add(scroll2);

        JButton exitButton=new JButton("back");
        exitButton.setBounds(300,400,100,30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showMenuPage();
            }
        });
        add(exitButton);

        forCurrent=new JComboBox(currentOrdersId);
        forCurrent.setBounds(30,330,100,30);
        add(forCurrent);

        toReadyButton=new JButton("ready");
        toReadyButton.setBounds(140,330,100,30);
        toReadyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Order order:DataBase.orders){
                    if(order.getId()== Integer.parseInt(String.valueOf(forCurrent.getSelectedItem()))){
                        order.changeReadyStatus();
                        System.out.println(order);
                    }
                }
                update();
            }
        });
        add(toReadyButton);

        forReady=new JComboBox(readyOrdersId);
        forReady.setBounds(350,330,100,30);
        add(forReady);

        toTakeButton=new JButton("take");
        toTakeButton.setBounds(460,330,100,30);
        toTakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Order order:DataBase.orders){
                    if(order.getId()==Integer.parseInt(String.valueOf(forReady.getSelectedItem()))){
                        order.changeTakeStatus();
                        System.out.println(order);
                    }
                }
                update();
            }
        });
        add(toTakeButton);

    }
    void update(){
        table1.setText("");
        forCurrent.removeAllItems();
        forReady.removeAllItems();;
        String str = "";
        for (int i = 0; i < DataBase.orders.size(); i++) {
            if (!DataBase.orders.get(i).isReady()) {
                str += DataBase.orders.get(i).print() + "\n"+DataBase.orders.get(i).getFullPrice()  + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";

                forCurrent.addItem(DataBase.orders.get(i).getId());
            }
        }
        if(str.length()==0) str="No current Order";
        table1.append(str);

        str="";
        table2.setText("");
        for(int i=0;i<DataBase.orders.size();i++) {
            if (DataBase.orders.get(i).isReady() && !DataBase.orders.get(i).isTake()) {
                str += DataBase.orders.get(i).print() + "\n"+DataBase.orders.get(i).getFullPrice()  + "\n" + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "\n" + "\n";

                DataBase.saveOrders();
                forReady.addItem(DataBase.orders.get(i).getId());
            }
        }
        if(str.length()==0) str="No ready Order";
        table2.append(str);

    }
}
