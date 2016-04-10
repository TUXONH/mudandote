/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class cargar extends Thread {
    JProgressBar progreso;
    JLabel porcentaje;
    public cargar(JProgressBar progreso, JLabel porcentaje)
    {
        super();
        this.porcentaje = porcentaje;
        this.progreso = progreso;
    }
    @Override
    public void run()
    {
        for(int i= 1; i<=100; i++)
        {
            progreso.setValue(i);
            porcentaje.setText(i+"&");
            pausa(30);
        }
    }
    public void pausa(int mlSeg)
    {
        try
        {
            Thread.sleep(mlSeg);
        }
        catch(Exception e)
        {
            
        }
    }
}
