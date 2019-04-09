/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shoppingcart;

import java.util.ArrayList;
import java.util.List;

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
        return items;
    }

    public static ShoppingItem getItem(String product) {
        for (ShoppingItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }
    
}
