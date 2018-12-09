
package controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.net.ssl.SSLContext;
import view.Signup_Patient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class LoginController {
    
     private Signup_Patient gui;

    public LoginController(Signup_Patient gui) {
        this.gui = gui;
        gui.getSubmitBnt().addActionListener(new ConvertButtonHandler());
    }

    class ConvertButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

            if(gui.checker){
                // This code ignores SSL certificates when dealing with HTTPS
                SSLContext sslcontext = SSLContexts.custom()
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
                CloseableHttpClient httpclient = HttpClients.custom()
                        .setSSLSocketFactory(sslsf)
                        .build();
                Unirest.setHttpClient(httpclient);

                String userPassword = gui.getPasswordPatientTextField().getPassword().toString();

                String json = Unirest.get("http://usfngm.com/login.php?password=" + userPassword).asString().getBody();
                PasswordResponse result = new Gson().fromJson(json, PasswordResponse.class);

                // Get Rate from JSON response
                String newPassword = result.getResult();

                // Finally, setting the result
                gui.getFakePassword().setText(newPassword);
            }
                                
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        }
    }
    
}
