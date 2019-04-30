/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ShoppingCart {

    private static List<ShoppingItem> items = new ArrayList();

    static {
        items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ShoppingItem item = new ShoppingItem();
            item.setProduct("book" + i);
            item.setAmount(5);
            item.setUnitprice(50);
            items.add(item);
        }
    }

    public static List<ShoppingItem> getitems() {
        ArrayList<ShoppingItem> items = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shopping_cart");
            while (rs.next()) {
                ShoppingItem item = new ShoppingItem();
                item.setProduct(rs.getString("product"));
                item.setUnitprice(rs.getDouble("unitPrice"));
                item.setAmount(rs.getInt("amount"));
                items.add(item);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);

        }
        return items;
    }

    public static ShoppingItem getItem(String product) {
        /*or (ShoppingItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;*/
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shopping_cart WHERE product ='" + product + "'");
            if (rs.next()) {
                ShoppingItem item = new ShoppingItem();
                item.setProduct(rs.getString("product"));
                item.setUnitprice(rs.getDouble("unitPrice"));
                item.setAmount(rs.getInt("amount"));
                return item;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean updateItem(ShoppingItem item) {
        /*ShoppingItem oldItem = getItem(item.getProduct());
        oldItem.setAmount(item.getAmount());
        oldItem.setUnitprice(item.getUnitprice());*/

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "", "");) {
            Statement stmt = conn.createStatement();
            int ret = stmt.executeUpdate("UPDATE shopping_cart SET unitPrice='" + item.getUnitprice() + "',amount='" + item.getAmount() + "'WHERE product ='" + item.getProduct() + "'");
            return ret == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean removeItem(String product) {
        /*int index = -1;
        for (int i = 0; i < items.size(); i++) {
            ShoppingItem item = items.get(i);
            if (item.getProduct().equals(product)) {
                index = i;
                break;
            }
        }
        items.remove(index);*/

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "", "");) {
            Statement stmt = conn.createStatement();
            int ret = stmt.executeUpdate("DELETE FROM shopping_cart WHERE product='" + product + "'");
            return ret == 1;
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }

    public static boolean addITem(ShoppingItem item) {
        //items.add(item);

        ShoppingItem oldItem = getItem(item.getProduct());
        if (oldItem != null) {
            updateItem(item);
        } else {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "", "");) {
                Statement stmt = conn.createStatement();
                int ret = stmt.executeUpdate("INSERT INTO shopping_cart (product, unitPrice, amount) VALUES('" + item.getProduct() + "','" + item.getUnitprice() + "','" + item.getAmount() + "')");
                return ret == 1;
            } catch (SQLException ex) {
                Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

}
