/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author danielandrademaglioni
 */
public class Llenar extends Thread{
          public JProgressBar progress;
  
    public int numero;
    protected Semaphore Finp1;
    public JLabel label;
    public Llenar(int numero, JProgressBar progress,JLabel label)
    {
        this.numero = numero;
        this.progress = progress;
        this.label = label;
    }
    
    public void run()
    {
        
        
        
       progress.setStringPainted(true);
       label.setSize(240, 60);
      
                    try
                {
          
                 for(int i=0;i<=numero;i++)
                    {
                        label.setSize(240, 60);
                        if(i>=0&&i<11)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion1.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>11&&i<20)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion2.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>21&&i<30)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion3.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>31&&i<40)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion4.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>41&&i<50)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion5.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>51&&i<60)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion6.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>61&&i<70)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion7.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>71&&i<80)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion8.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>81&&i<90)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion9.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        if(i>91&&i<=100)
                            {
                                ImageIcon fot = new ImageIcon("C:\\Users\\josegonzalez\\Desktop\\mudandote\\src\\img\\camion10.png");
                                Icon icono = new ImageIcon(fot.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT));
                                 label.setIcon(icono);
        
                            }
                        
                        
                        progress.setValue(i);
                        
                        
                        sleep((int) Math.round(numero* Math.random()-0.5));
                        label.setSize(240, 60);
                        
                    }
        }
        
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
       
    }

    
}
