package main;


import controller.Controller;
import java.awt.Component;
import java.awt.Panel;
import java.util.Date;
import javax.swing.JComponent;
import view.*;
import model.*;
//import controller.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangeyes
 */
public class Atlas {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        final TabbedMenu mainPanel = new TabbedMenu();
        
        //Inicjalizacja i uruchomienie okna Swing
        /*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Atlas Zwierząt");
                frame.setSize(400, 300);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(mainPanel);
                frame.setVisible(true);
                frame.setLocation(200, 300);
            }
        });*/
        
       Model theModel = new Model();
       View theView = new View();
       Controller theController = new Controller(theView, theModel);
       
       theView.run();
       
       
      
    }
    
}
