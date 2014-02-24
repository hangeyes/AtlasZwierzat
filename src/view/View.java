/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.Family;
import model.Phylum;
import model.Species;

/**
 *
 * @author Hangeyes
 */
public class View extends JFrame implements Runnable{
    
    private TabbedMenu mainPanel = new TabbedMenu();
    
    /**
     *Main class used in managing visual side of the application.
     */
    public View() {
        mainPanel.addPanel.phylumNameCB.removeAllItems();
        mainPanel.addPanel.familyNameCB.removeAllItems();
        mainPanel.addPanel.speciesName1CB.removeAllItems();
        mainPanel.addPanel.speciesName2CB.removeAllItems();
        mainPanel.addPanel.speciesNameCB.removeAllItems();
        mainPanel.addPanel.speciesName1CB.addItem("");
        mainPanel.addPanel.speciesName2CB.addItem("");
        mainPanel.addPanel.speciesNameCB.addItem("");
        mainPanel.addPanel.phylumNameCB.addItem("");
        mainPanel.addPanel.familyNameCB.addItem("");
        
        
        this.setSize(600, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainPanel);
        
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
    
    /**
     *
     * @return
     */
    public String getCheckedRadioButton()
    {
        return mainPanel.addPanel.getCheckedRadioButton();
    }
    
   /**
    Sets text value of specified text field in AddTab.
    */
    
    public void setFamilyAverageLimbCountTextField(String t)
    {
        mainPanel.addPanel.familyAverageLimbCountTextField.setText(t);            
    }
    
    /**
    Sets text value of specified text field in AddTab.
    */
    
    public String getFamilyAverageLimbCountTextField()
    {
        return mainPanel.addPanel.familyAverageLimbCountTextField.getText();            
    }
    
    /**
    Sets text value of specified text field in AddTab.
    */
    
    public void setFamilyCharacteristicTextField(String t)
    {
        mainPanel.addPanel.familyCharacteristicTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getFamilyCharacteristicTextField()
    {
        return mainPanel.addPanel.familyCharacteristicTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setFamilyNameTextField(String t)
    {
        mainPanel.addPanel.familyNameTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getFamilyNameTextField()
    {
        return mainPanel.addPanel.familyNameTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setPhylumAnatomyTextField(String t)
    {
        mainPanel.addPanel.phylumAnatomyTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getPhylumAnatomyTextField()
    {
        return mainPanel.addPanel.phylumAnatomyTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setPhylumNameTextField(String t)
    {
        mainPanel.addPanel.phylumNameTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getPhylumNameTextField()
    {
        return mainPanel.addPanel.phylumNameTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setPhylumPopulationTextField(String t)
    {
        mainPanel.addPanel.phylumPopulationTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab. 
    */
    
    public String getPhylumPopulationTextField()
    {
        return mainPanel.addPanel.phylumPopulationTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setSpeciesDiscoveryDateTextField(String t)
    {
        mainPanel.addPanel.speciesDiscoveryDateTextField.setText(t);
    }
    
/**
    Returns text value of specified text field in AddTab.
     * @return 
    */
    
    public String getSpeciesDiscoveryDateTextField()
    {
        return mainPanel.addPanel.speciesDiscoveryDateTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setSpeciesNameTextField(String t)
    {
        mainPanel.addPanel.speciesNameTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
     * @return 
    */
    
    public String getSpeciesNameTextField()
    {
        return mainPanel.addPanel.speciesNameTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setSpeciesLimbCountTextField(String t)
    {
        mainPanel.addPanel.speciesLimbCountTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getSpeciesLimbCountTextField()
    {
        return mainPanel.addPanel.speciesLimbCountTextField.getText();
    }
    
    /**
     *
     * @param t
     */
    public void setSpeciesRepresentantTextField(String t)
    {
        mainPanel.addPanel.speciesRepresentantTextField.setText(t);
    }
    
    /**
    Returns text value of specified text field in AddTab.
    */
    
    public String getSpeciesRepresentantTextField()
    {
        return mainPanel.addPanel.speciesRepresentantTextField.getText();
    }
    
    /**
     *
     * @param l
     */
    public void addAddButtonActionListener(ActionListener l)
    {
        mainPanel.addPanel.addButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addEditButtonActionListener(ActionListener l)
    {
        mainPanel.addPanel.editButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addDeleteButtonActionListener(ActionListener l)
    {
        mainPanel.addPanel.deleteButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSearchButtonActionListener(ActionListener l)
    {
        mainPanel.searchEditPanel.searchButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addShowAllButtonActionListener(ActionListener l)
    {
        mainPanel.searchEditPanel.showAllButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSearchByFamilyButtonActionListener(ActionListener l)
    {
        mainPanel.searchEditPanel.searchByFamilyButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSearchByLimbCountButtonActionListener(ActionListener l)
    {
        mainPanel.searchEditPanel.searchByLimbCountButton.addActionListener(l);
    }
    
    /**
     *
     * @param s
     */
    public void setSearchTextField(String s)
    {
        mainPanel.searchEditPanel.searchTextField.setText(s);
    }
    
    /**
     *
     * @return
     */
    public String getSearchTextField()
    {
        return mainPanel.searchEditPanel.searchTextField.getText();
    }
    
    /**
     *
     * @param l
     */
    public void addLoadButtonActionListener(ActionListener l)
    {
        mainPanel.saveLoadPanel.loadButton.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSaveButtonActionListener(ActionListener l)
    {
        mainPanel.saveLoadPanel.saveButton.addActionListener(l);
    }
    
    /*
    Returns text value of specified combobox in AddTab.
    */
    
    public String getPhylumComboBoxSelectedValue()
    {
        return mainPanel.addPanel.phylumNameCB.getSelectedItem().toString();
    }
    
    /**
    Returns text value of specified combo box in AddTab.
    */
    
    public String getFamilyComboBoxSelectedValue()
    {
        return mainPanel.addPanel.familyNameCB.getSelectedItem().toString();
    }
    
    /**
    Returns text value of selected item in specified combo box.
    */
    
    public String getCurrentSpeciesComboBoxSelectedValue()
    {
        return mainPanel.addPanel.speciesNameCB.getSelectedItem().toString();
    }
    
    /**
    Sets text value of specified combo box in AddTab.
    */
    
    public void setPhylumComboBoxSelectedValue(String key)
    {
        mainPanel.addPanel.phylumNameCB.setSelectedItem(key);
    }
    
    /**
    Sets text value of specified combo box in AddTab.
    */
    
    public void setFamilyComboBoxSelectedValue(String key)
    {
        mainPanel.addPanel.familyNameCB.setSelectedItem(key);
    }
    
    /**
    Sets text value of specified combo box in AddTab.
    */

    public void setSpeciesCurrentComboBoxSelectedValue(String key)
    {
        mainPanel.addPanel.speciesNameCB.setSelectedItem(key);
    }
    
    /**
    Sets text value of specified combo box in AddTab.
    */

    public void setSpeciesName1ComboBoxSelectedValue(String key)
    {
        mainPanel.addPanel.speciesName1CB.setSelectedItem(key);
    }
    
    /*
    Sets text value of specified combobox in AddTab
    */

    /**
     *
     * @param key
     */
    
    public void setSpeciesName2ComboBoxSelectedValue(String key)
    {
        mainPanel.addPanel.speciesName2CB.setSelectedItem(key);
    }
    
    /**
     *
     * @param l
     */
    public void addPhylumNameCBActionListener(ActionListener l)
    {
        mainPanel.addPanel.phylumNameCB.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addFamilyNameCBActionListener(ActionListener l)
    {
        mainPanel.addPanel.familyNameCB.addActionListener(l);
    }
    
    /**
     *
     * @param l
     */
    public void addSpeciesNameCBActionListener(ActionListener l)
    {
        mainPanel.addPanel.speciesNameCB.addActionListener(l);
    }
    
    /**
     *Returns currently selected value of Species Combo box
     */
    public String[] getSpeciesComboBoxSelectedValue()
    {
        String[] values = new String[2];
      
        values[0] = mainPanel.addPanel.speciesName1CB.getSelectedItem().toString();
        values[1] = mainPanel.addPanel.speciesName2CB.getSelectedItem().toString();
        
        
        return values;
    }
    
    /**
     *Updates Phylum Combo box in AddTab with list specified in parameter.
     */
    public void phylumComboBoxUpdate(HashMap<String, Phylum> values)
    {
        mainPanel.addPanel.phylumNameCB.removeAllItems();
        Iterator<String> key = values.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            mainPanel.addPanel.phylumNameCB.addItem(values.get(i).getPhylumName());
            System.out.println(values.get(i).getPhylumName());
        }
        mainPanel.addPanel.phylumNameCB.insertItemAt("", 0);
        
    }
    
    /**
     *Updates Family Combo box in AddTab with list specified in parameter.
     */
    public void familyComboBoxUpdate(HashMap<String, Family> values)
    {
        mainPanel.addPanel.familyNameCB.removeAllItems();
        Iterator<String> key = values.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            mainPanel.addPanel.familyNameCB.addItem(values.get(i).getFamilyName());
        }
        mainPanel.addPanel.familyNameCB.insertItemAt("", 0);
    }
    
    /**
     *Updates Species Combo box in AddTab with list specified in parameter.
     */
    public void speciesComboBoxUpdate(HashMap<String, Species> values)
    {
        mainPanel.addPanel.speciesName1CB.removeAllItems();
        mainPanel.addPanel.speciesName2CB.removeAllItems();
        mainPanel.addPanel.speciesNameCB.removeAllItems();
        Iterator<String> key = values.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            mainPanel.addPanel.speciesName1CB.addItem(values.get(i).getSpeciesName());
            mainPanel.addPanel.speciesName2CB.addItem(values.get(i).getSpeciesName());
            mainPanel.addPanel.speciesNameCB.addItem(values.get(i).getSpeciesName());
            
            
        }
        mainPanel.addPanel.speciesName1CB.insertItemAt("", 0);
        mainPanel.addPanel.speciesName2CB.insertItemAt("", 0);
    }
    
    /**
     *
     * @return
     */
    public File chooseFolder()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Proszę wybrać folder do zapisu/odczytu");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            return chooser.getSelectedFile();
        } else
            return new java.io.File(".");
    }
    
    /**
     *
     * @param s
     */
    public void setNameLabelText(String s)
    {
        mainPanel.searchEditPanel.nameLabel.setText(s);
    }
    
    /**
     *
     * @param s
     */
    public void setFamilyNameLabelText(String s)
    {
        mainPanel.searchEditPanel.familyNameLabel.setText(s);
    }
    
    /**
     *
     * @param s
     */
    public void setSpeciesLabel (String[] s)
    {
        mainPanel.searchEditPanel.species1Label.setText(s[0]);
        mainPanel.searchEditPanel.species2Label.setText(s[1]);
    }
    
    /**
     *
     * @param s
     */
    public void setLimbCountLabel (String s)
    {
        mainPanel.searchEditPanel.limbCountLabel.setText(s);
    }
    
    /**
     *
     * @param s
     */
    public void setDiscoveryDateLabel (String s)
    {
        mainPanel.searchEditPanel.discoveryDateLabel.setText(s);
    }
    
    /**
     *
     * @param s
     */
    public void setRepresentantLabel (String s)
    {
        mainPanel.searchEditPanel.representantLabel.setText(s);
    }
    
    /**
     *Updates Search Results ComboBox with list
     */
    public void searchResultsComboBoxUpdate(HashMap<String, Species> values)
    {
      
        mainPanel.searchEditPanel.searchResultsCB.removeAllItems();
        Iterator<String> key = values.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            mainPanel.searchEditPanel.searchResultsCB.addItem(values.get(i).getSpeciesName());   
        }
    }
    
    /**
     *
     * @return
     */
    public String getSearchResultsComboBoxSelectedValue ()
    {
        return (String) mainPanel.searchEditPanel.searchResultsCB.getSelectedItem();
    }
    
    /**
     *
     * @param l
     */
    public void addSearchResultsComboBoxActionListener (ActionListener l)
    {
        mainPanel.searchEditPanel.searchResultsCB.addActionListener(l);
    }
    
    /**
     *
     * @return
     */
    public JButton getSearchButton ()
    {
        return mainPanel.searchEditPanel.searchButton;
    }
}
