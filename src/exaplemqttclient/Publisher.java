/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exaplemqttclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pigo
 */
public class Publisher extends Thread
{
    mainJFrame x = new mainJFrame();
    int times, delay;
    
    Publisher(mainJFrame jF, int t, int d) throws InterruptedException
    {
        x = jF;
        times = t;
        delay = d;
        this.start();
        
    }

    @Override
    public void run() 
    {
            System.out.println("lol");
            try {
                for(int i=1; i<=times && x.canPublish == true; i++)
                {
                    this.sleep(delay);
                    x.publish();
                }
                x.canPublish = false;
            } catch (Exception ex) {
                Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            }      
    }
    
}
