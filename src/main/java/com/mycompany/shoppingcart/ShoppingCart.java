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

    public static void updateItem(ShoppingItem item) {
        ShoppingItem oldItem = getItem(item.getProduct());
        oldItem.setAmount(item.getAmount());
        oldItem.setUnitprice(item.getUnitprice());
    }

    public static void removeItem(String product) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            ShoppingItem item = items.get(i);
            if (item.getProduct().equals(product)) {
                index = i;
                break;
            }
        }
        items.remove(index);
    }

    public static void addITem(ShoppingItem item) {
        items.add(item);
    }

}
