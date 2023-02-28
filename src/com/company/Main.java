package com.company;

import java.util.TreeMap;

public class Main {
    public static  MainFrame mainFrame;
    public static void main(String[] args)  {

        mainFrame=new MainFrame();
        mainFrame.setVisible(true);

    }
    public static void showMenuPage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(true);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);

    }
    public static void showStartPage(){
        mainFrame.startPage.setVisible(true);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);
    }
    public static void showTablePage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(true);
        mainFrame.tablePage.update();
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);
    }
    public static void showAddProductPage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(true);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);
    }
    public static void showListOfOrdersPage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(true);
        mainFrame.listOfOrdersPage.update();
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);
    }

    public static void showAddClientPage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(true);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.setVisible(false);
    }

    public static void showCurrentOrdersPage(){
        mainFrame.currentOrdersPage.update();
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(true);
        mainFrame.addOrderPage.setVisible(false);
    }


    public static void showAddOrderPage(){
        mainFrame.startPage.setVisible(false);
        mainFrame.tablePage.setVisible(false);
        mainFrame.mainMenuPage.setVisible(false);
        mainFrame.addProductPage.setVisible(false);
        mainFrame.listOfOrdersPage.setVisible(false);
        mainFrame.addClientPage.setVisible(false);
        mainFrame.currentOrdersPage.setVisible(false);
        mainFrame.addOrderPage.update();
        mainFrame.addOrderPage.setVisible(true);
    }
}