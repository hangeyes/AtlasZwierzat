/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Hangeyes
 */
public class SaveLoadTab extends JPanel{
    
    JButton saveButton;
    JButton loadButton;
    
    public SaveLoadTab()
    {
        saveButton = new JButton("Zapisz do pliku");
        loadButton = new JButton("Wczytaj z pliku");
        this.add(saveButton);
        this.add(loadButton);
    }
}
