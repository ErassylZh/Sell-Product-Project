package com.company.Frames;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends Container {
    private final String AdminName="ADMIN";
    private  final String AdminPass="QWERTY1";
    public StartPage(){
        setSize(700,500);
        setLayout(null);

        JLabel log = new JLabel("login:");
        JLabel pass=new JLabel("password:");

        log.setSize(250,60);
        log.setLocation(100,100);
        add(log);

        pass.setSize(250,60);
        pass.setLocation(100,170);
        add(pass);

        JTextField login=new JTextField(AdminName);
        login.setSize(400,30);
        login.setLocation(170,110);
        add(login);

        JTextField password=new JTextField(AdminPass);
        password.setSize(400,30);
        password.setLocation(170,185);
        add(password);

        JButton btn=new JButton("log in");
        btn.setSize(100,30);
        btn.setLocation(300,240);
        add(btn);

        JButton table=new JButton("open table");
        table.setSize(100,30);
        table.setLocation(470,240);
        table.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showTablePage();;
            }
        });
        add(table);


        JLabel alert=new JLabel("");
        alert.setSize(200,30);
        alert.setLocation(280,280);
        add(alert);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log=login.getText();
                String pass=password.getText();
                if((pass.equals(AdminPass)&&(log.equals(AdminName)))){
                    Main.showMenuPage();

                }else{
                    alert.setText("Incorrect password or login");
                }

            }
        });
    }
}
