/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.ShopList;

/**
 *
 * @author david
 */
public class ShopListService {
    
    private final ShopList myShopList;
    
    public ShopListService() {
        this.myShopList = new ShopList();
    }
    
    public ShopList getShoppingList() {
        return myShopList;
    }
    
    public void addItem(String item){
        if (item.length() > 0) {
            myShopList.addItem(item);
        }
    }
    
    public void deleteItem(String item) {
        if (myShopList.length() > 0) {
            myShopList.deleteItem(item);
        }
    }
    
    
}
    
    
    


