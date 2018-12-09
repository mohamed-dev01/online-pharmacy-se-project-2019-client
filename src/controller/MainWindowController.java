package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Signup_Patient;
import model.PManagerInterface;
import view.MainWindow;


public class MainWindowController {
    
    // We have reference to both the GUI and the rmi registry
    MainWindow gui;
    Registry r;
    Signup_Patient patient;
    // The constructor takes the gui and the rmi registry as paramaters
    public MainWindowController(MainWindow gui, Registry r, Signup_Patient patient)
    {
        this.gui = gui;
        this.r = r;
        this.patient = patient;
        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new GetGradeBtnAction());
    }
    
    
    // This class is responsible for handling the button click
    class GetGradeBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                PManagerInterface g = (PManagerInterface) r.lookup("input1");
                PManagerInterface x = (PManagerInterface) r.lookup("input2");
                PManagerInterface c = (PManagerInterface) r.lookup("input3");
                PManagerInterface v = (PManagerInterface) r.lookup("input4");
                // Get the grade (in numbers) as it is written inside the text field
                // Please note that we are able to interact with the gui elements through
                // the getters that we have set up earlier
                
                // Also we are parsing to int below because by default, the text field
                // will return a string
                int input1 = Integer.parseInt(gui.getjTextField1().getText());
                int input2 = Integer.parseInt(gui.getjTextField3().getText());
                int input3 = Integer.parseInt(gui.getjTextField6().getText());
                int input4 = Integer.parseInt(gui.getjTextField7().getText());
                // Once we have the grade as numbers, we can pass it to the remote
                // function getGrade using our remote reference g
                
                //===============================================
                //add signup page info to database
                
                String s1 = patient.getFakePassword().toString();
                String s2 = patient.getUserNamePatientTextField().toString();
                String s3 = patient.getEmailPatientTextField().toString();
          
                String result = g.GetProfit(input1,input2,input3,input4);
                g.addToDatabase(input1, input2, input3, input4);
//                g.addInfoToDatabase(s2, s1, s3);
              
                
                // Once we got the result from our remote object, we can set it to
                // appear inside the gui using the jLabel
                gui.getjLabel1().setText(result);
                
                
               
            } catch (RemoteException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
