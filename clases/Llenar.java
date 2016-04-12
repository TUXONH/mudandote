/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import javax.swing.JProgressBar;

/**
 *
 * @author danielandrademaglioni
 */
public class Llenar extends Thread{
          public JProgressBar progress;
  
    public int numero;
    protected Semaphore Finp1;
    public Llenar(int numero, JProgressBar progress)
    {
        this.numero = numero;
        this.progress = progress;
    }
    
    public void run()
    {
        
        
        
       progress.setStringPainted(true);
       progress.setValue(0);
                    try
                {
          
                 for(int i=0;i<=numero;i++)
                    {
                        progress.setValue(i);
                        
                        
                        sleep((int) Math.round(numero* Math.random()-0.5));
                        
                    }
        }
        
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
       
    }

    
}
