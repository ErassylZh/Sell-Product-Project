package com.company;

import com.company.Frames.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    public StartPage startPage;
    public TablePage tablePage;
    public MainMenuPage mainMenuPage;
    public ListOfOrdersPage listOfOrdersPage;
    public AddProductPage addProductPage;
    public AddClientPage addClientPage;
    public CurrentOrdersPage currentOrdersPage;
    public AddOrderPage addOrderPage;
    MainFrame(){
        setSize(700,500);
        setTitle("Ichiraku Coffee");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPage=new StartPage();
        startPage.setVisible(true);
        add(startPage);

        tablePage=new TablePage();
        tablePage.setVisible(false);
        add(tablePage);

        mainMenuPage=new MainMenuPage();
        mainMenuPage.setVisible(false);
        add(mainMenuPage);

        addProductPage=new AddProductPage();
        addProductPage.setVisible(false);
        add(addProductPage);

        listOfOrdersPage=new ListOfOrdersPage();
        listOfOrdersPage.setVisible(false);
        add(listOfOrdersPage);

        addClientPage=new AddClientPage();
        addClientPage.setVisible(false);
        add(addClientPage);

        currentOrdersPage=new CurrentOrdersPage();
        currentOrdersPage.setVisible(false);
        add(currentOrdersPage);

        addOrderPage=new AddOrderPage();
        addOrderPage.setVisible(false);
        add(addOrderPage);
    }
}
