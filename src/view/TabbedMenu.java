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

    /*private JComponent makeAddPanel() {
        //Tworzenie komponentów panelu
        JPanel panel = new JPanel(false);
        panel.setLayout(new BorderLayout());
        JComboBox selectPhylum = new JComboBox();
        JComboBox selectFamily = new JComboBox();
        JComboBox selectSpecies = new JComboBox();
        JLabel phylumName = new JLabel("Typ:");
        JLabel familyName = new JLabel("Rodzina:");
        JLabel speciesName = new JLabel("Gatunek:");
        JTextArea populationTA = new JTextArea("Populacja");
        JTextArea anatomyTA = new JTextArea("Budowa");
        JTextArea characteristicTA = new JTextArea("Charakterystyka");
        JTextArea averageLimbCountTA = new JTextArea("Średnia liczba kończyn");
        JComboBox selectSpecies1 = new JComboBox();
        JComboBox selectSpecies2 = new JComboBox();
        JTextArea discoveryDateTA = new JTextArea("Rok odkrycia");
        JTextArea limbCountTA = new JTextArea("Liczba kończyn gatunku");
        JTextArea representantNameTA = new JTextArea("Reprezentant");
        JButton addButton = new JButton("Dodaj wpis");
        
        //selectSpecies1.set
        
        //Pozycjonowanie i ustawienia widoczności
        selectFamily.setVisible(false);
        //familyName.setVisible(false);
        selectSpecies.setVisible(false);
        selectSpecies1.setVisible(false);
        selectSpecies2.setVisible(false);
        speciesName.setVisible(false);
        characteristicTA.setVisible(false);
        averageLimbCountTA.setVisible(false);
        discoveryDateTA.setVisible(false);
        limbCountTA.setVisible(false);
        representantNameTA.setVisible(false);
        
       
        
        //Dodawanie komponentów do panelu
        panel.add(phylumName,BorderLayout.LINE_START);
        panel.add(selectPhylum,BorderLayout.LINE_END);
        panel.add(populationTA);
        panel.add(anatomyTA);
        panel.add(familyName,BorderLayout.LINE_START);
        panel.add(selectFamily);
        panel.add(characteristicTA);
        panel.add(averageLimbCountTA);
        panel.add(speciesName);
        panel.add(selectSpecies);
        panel.add(selectSpecies1);
        panel.add(selectSpecies2);
        panel.add(discoveryDateTA);
        panel.add(limbCountTA);
        panel.add(representantNameTA);
        panel.add(addButton,BorderLayout.PAGE_END);
        
        
        return panel;
        
    }*/
    
    /*private JComponent makeSearchEditPanel() {
        JPanel panel = new JPanel(false);
        JTextField searchTextField = new JTextField("Wpisz nazwę");
        JButton searchButton  = searchButton = new JButton("Wyszukaj");
        
        panel.add(searchTextField);
        panel.add(searchButton);
        
        return panel;
    }*/
    
    /*private JComponent makeSaveLoadPanel() {
        JPanel panel = new JPanel(false);
        JButton saveButton = new JButton("Zapisz do pliku");
        JButton loadButton = new JButton("Wczytaj z pliku");
        
        panel.add(saveButton);
        panel.add(loadButton);
        
        return panel;
    }*/
    
   }

