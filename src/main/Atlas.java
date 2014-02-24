package main;


import controller.Controller;

import view.*;
import model.*;
import controller.*;

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
        
       Model theModel = new Model();
       View theView = new View();
       Controller theController = new Controller(theView, theModel);
       
       theView.run();
       
       
      
    }
    
}
