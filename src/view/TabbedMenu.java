package view;


import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangeyes
 */
public class TabbedMenu extends JPanel{
    
    AddTab addPanel = new AddTab();
    SearchEditTab searchEditPanel = new SearchEditTab();
    SaveLoadTab saveLoadPanel = new SaveLoadTab();
    
    /**
     *Creates tabbed menu and adds every tab
     */
    public TabbedMenu() {
        super (new GridLayout(1,1));
        JTabbedPane tabbedPane = new JTabbedPane();
        
        
        //AddTab addPanel = new AddTab(); 
        tabbedPane.addTab("Dodaj/Edytuj/Usuń", addPanel);
        
        //JComponent searchEditPanel = makeSearchEditPanel();
        tabbedPane.addTab("Szukaj", searchEditPanel);
       
        //JComponent saveLoadPanel = makeSaveLoadPanel();
        tabbedPane.addTab("Zapisz/Wczytaj",saveLoadPanel);

        this.add(tabbedPane);
    }
   }

