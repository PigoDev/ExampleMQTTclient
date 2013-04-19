/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exaplemqttclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pigo
 */
public class Connecter extends Thread
{
    mainJFrame x = new mainJFrame();
    String functionName;
    long time;
    
    Connecter(mainJFrame jF, String f) throws InterruptedException
    {
        x = jF;
        functionName = f;
        time = System.currentTimeMillis();
        this.start();
        
    }
    @Override
    public void run() 
    {
        while(System.currentTimeMillis() < (time+5000))
        {
            switch(functionName)
            {
                case "IP":
                {
                    try {
                        x.connectIP();
                    } catch (Exception ex) {
                        Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }break;
                case "SERVER":
                {
                    try {
                        x.connectServer();
                    } catch (Exception ex) {
                        Logger.getLogger(Connecter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        if(x.connection.isConnected()==false)
        {JOptionPane.showMessageDialog(null, "Request timeout.");}
    }
}
