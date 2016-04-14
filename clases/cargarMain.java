/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author josegonzalez
 */
public class cargarMain extends Thread {
    public JLabel label;
    
    public cargarMain(JLabel label)
            {
                
                this.label = label;
        
    }
    public void run()
    {
                    
          label.setSize(240, 60);
        for(int i=0;i<100;i++)
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
        }
    }
    
}
