
package testing;

import controller.PasswordResponse;
import controller.LoginController;
import view.Signup_Patient;
import static org.junit.Assert.*;
import org.junit.Test;
import view.MainWindow;

public class JUnitTesting {
    
    Signup_Patient patient = new Signup_Patient();
    MainWindow mainWindow = new MainWindow();
    PasswordResponse passwordResponse = new PasswordResponse();
    
    @Test
    public void testPatientForm(){
        
        assertFalse(patient.getEmailPatientTextField().equals("mohamedc@outlook.com"));   
    }
    
    @Test
    public void testChecker(){
        assertTrue(patient.checker);
        
    }
    
    @Test
    public void testTotelProfit(){
        assertEquals(1000, Integer.parseInt(mainWindow.getjTextField7().getText()));   
    }
    
    @Test
    public void checkServiceRespons(){
        
        String x = passwordResponse.getResult();
        boolean y = false;
        
        if(x instanceof String){
            y = true;
        }
        
        assertTrue(y);       
    }
    

}
