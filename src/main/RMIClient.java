/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.LoginController;
import controller.MainWindowController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import view.Signup_Patient;
import model.PManagerInterface;
import view.MainWindow;
import view.MainWindow;

public class RMIClient {


    public static void main(String[] args) throws RemoteException {

        // We create an object from the GUI window
        MainWindow gui = new MainWindow();
        //gui.setLocationRelativeTo(null); // This makes the window appears centered
       // gui.setVisible(true); // This shows the gui
        
        Signup_Patient patient = new Signup_Patient();
        
        patient.setLocationRelativeTo(null); // This makes the window appears centered
        patient.setVisible(true); // This shows the gui
        
        new LoginController(patient);
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1011);
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        MainWindowController gui_controller = new MainWindowController(gui, r, patient);
        
    }
    
}
