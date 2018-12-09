/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PManagerInterface extends Remote {
    String GetProfit(int  g, int x,int c,int v) throws RemoteException;
    public void addToDatabase(int product_price, int saleries, int adv, int total_sales) throws RemoteException;
    

}

