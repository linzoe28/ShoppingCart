/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shoppingcart;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("item")
public class ShoppingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public ShoppingItem getItem(@PathParam("id") String name) {

        return ShoppingCart.getItem(name);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateItem(ShoppingItem item) {
        ShoppingCart.updateItem(item);
    }

    @DELETE
    @Path("{product}")
    public void removeItem(@PathParam("product") String prodoct) {
        ShoppingCart.removeItem(prodoct);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void  addITem(ShoppingItem item){
       ShoppingCart.addITem(item);
    }
}
