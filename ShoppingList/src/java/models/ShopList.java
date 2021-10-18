/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class ShopList {
    
    
    public ArrayList<String> myShopList = new ArrayList<>();
       
    public ShopList() {
    }

    public ShopList(ArrayList<String> myShopList) {
        this.myShopList = myShopList;
    }

    
    public void addItem(String item){
        myShopList.add(item);
    }
    
    public void deleteItem(String item) {
        myShopList.remove(item);
    }
    
    public ArrayList<String> getShoppingListArray() {
        return myShopList;
    }
    
    public int length() {
        return myShopList.size();
    }
}
