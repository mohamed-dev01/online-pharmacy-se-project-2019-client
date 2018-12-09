/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mohamed Hany
 */
public interface AccountInterface extends Remote{
    public void addInfoToDatabase(String name, String password, String email) throws RemoteException;
    
}
