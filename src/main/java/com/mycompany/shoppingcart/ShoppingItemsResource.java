/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("items")
public class ShoppingItemsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShoppingItem> getItems(){
     
       return ShoppingCart.getitems();
    }
}
