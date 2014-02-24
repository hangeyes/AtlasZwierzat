/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import model.Family;
import model.Hybrid;
import view.View;
import model.Model;
import model.Phylum;
import model.Species;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Hangeyes
 */
public class Controller {
    
    private final View theView;
    private final Model theModel;
    private DefaultComboBoxModel phylumComboBoxModel;
    private DefaultComboBoxModel familyComboBoxModel;
    private DefaultComboBoxModel speciesComboBoxModel;
    private File phylumFile;
    private File familyFile;
    private File speciesFile;
    private Boolean loading;
    
    /**
     *
     * @param theView
     * @param theModel
     */
    public Controller(View theView, Model theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        this.loading = false;
        
        //theView.speciesComboBoxUpdate(theModel.getSpeciesMap());
        
        this.theView.addAddButtonActionListener(new AddButtonActionListener());
        this.theView.addLoadButtonActionListener(new LoadButtonActionListener());
        this.theView.addSearchButtonActionListener(new SearchButtonActionListener());
        this.theView.addSaveButtonActionListener(new SaveButtonActionListener());
        this.theView.addEditButtonActionListener(new EditButtonActionListener());
        this.theView.addDeleteButtonActionListener(new DeleteButtonActionListener());
        this.theView.addPhylumNameCBActionListener(new NameCBActionListener());
        this.theView.addFamilyNameCBActionListener(new NameCBActionListener());
        this.theView.addSpeciesNameCBActionListener(new NameCBActionListener());
        this.theView.addSearchButtonActionListener(new SearchButtonActionListener());
        this.theView.addShowAllButtonActionListener(new ShowAllButtonActionListener());
        this.theView.addSearchByFamilyButtonActionListener(new SearchButtonActionListener());
        this.theView.addSearchByLimbCountButtonActionListener(new SearchByLimbCountButtonActionListener());
        this.theView.addSearchResultsComboBoxActionListener(new SearchResultsComboBoxActionListener());
        
    }

    /**
     * @return the loading
     */
    public Boolean getLoading() {
        return loading;
    }

    /**
     * @param loading the loading to set
     */
    public void setLoading(Boolean loading) {
        this.loading = loading;
    }
    
    /**
     *Action listener for SearchResult ComboBox in Search Tab
     */
    public class SearchResultsComboBoxActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(loading==false)
            {
                loading = true;
                String key = theView.getSearchResultsComboBoxSelectedValue();
                if(!key.equals(""))
                {
                    if(theModel.getSpeciesItem(key).getClass() == Species.class)
                    {
                        Species species = theModel.getSpeciesItem(key);
                        String[] s = {"", ""};
                        theView.setNameLabelText(species.getSpeciesName());
                        theView.setSpeciesLabel(s);
                        theView.setFamilyNameLabelText(species.getFamily().getFamilyName());
                        theView.setRepresentantLabel(species.getRepresentantName());
                        theView.setLimbCountLabel(Integer.toString(species.getLimbCount()));
                        theView.setDiscoveryDateLabel(species.getDiscoveryDate());
                    } else
                    {
                        Hybrid species =(Hybrid) theModel.getSpeciesItem(key);
                        String[] s = species.getSpeciesNames();
                        theView.setNameLabelText(species.getSpeciesName());
                        theView.setSpeciesLabel(s);
                        theView.setFamilyNameLabelText(species.getFamily().getFamilyName());
                        theView.setRepresentantLabel(species.getRepresentantName());
                        theView.setLimbCountLabel(Integer.toString(species.getLimbCount()));
                        theView.setDiscoveryDateLabel(species.getDiscoveryDate());
                    }
                }
                loading = false;
            }
        }
        
    }
    
    /**
     * Action listener for Delete button
     */
    public class DeleteButtonActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            loading = true;
            String checkedRadioBox = theView.getCheckedRadioButton();
            switch (checkedRadioBox) {
                case "phylum" :
                    if(theView.getPhylumComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można usunąć pustego wpisu");
                        break;
                    }
                    theModel.removeItemFromPhylumHashMap(theView.getPhylumComboBoxSelectedValue());
                    theView.phylumComboBoxUpdate(theModel.getPhylumMap());
                    break;
                case "family" :
                    if(theView.getFamilyComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można usunąć pustego wpisu");
                        break;
                    }
                    theModel.removeItemFromFamilyHashMap(theView.getFamilyComboBoxSelectedValue());
                    theView.familyComboBoxUpdate(theModel.getFamilyMap());
                    break;
                case "species" :
                    if(theView.getCurrentSpeciesComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można usunać pustego wpisu");
                        break;
                    }
                    theModel.removeItemFromSpeciesHashMap(theView.getCurrentSpeciesComboBoxSelectedValue());
                    theView.speciesComboBoxUpdate(theModel.getSpeciesMap());
                    break;
                default :
                    JOptionPane.showMessageDialog(theView, "Proszę wybrać rodzaj wpisu");
                    break;
                    
            }
            loading = false;
        }
    }
    
    /**
     *Action listener for Edit button in Add Tab
     */
    public class EditButtonActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            loading = true;
            int p;
            String checkedRadioBox = theView.getCheckedRadioButton();
            switch (checkedRadioBox) {
                case "phylum":
                    if(theView.getPhylumComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można edytować pustego wpisu");
                        break;
                    }
                    theModel.removeItemFromPhylumHashMap(theView.getPhylumComboBoxSelectedValue());
                    try {
                        p=Integer.parseInt(theView.getPhylumPopulationTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Populacja musi być liczbą");
                        break;
                    }
                    theModel.addItemToPhylumMap(new Phylum(theView.getPhylumNameTextField(),Integer.parseInt(theView.getPhylumPopulationTextField()),theView.getPhylumAnatomyTextField()));
                    theView.phylumComboBoxUpdate(theModel.getPhylumMap());
                    break;
                case "family" :
                    if(theView.getFamilyComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można edytować pustego wpisu");
                        break;
                    }
                    float f;
                    try {
                        f=Float.parseFloat(theView.getFamilyAverageLimbCountTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Średnia ilość kończyn musi być liczbą");
                        break;
                    }
                    Phylum phylum = theModel.getPhylumItem(theView.getPhylumComboBoxSelectedValue());
                    if(phylum != null)
                    {
                        theModel.addItemToFamilyMap(new Family(phylum,theView.getFamilyNameTextField(),theView.getFamilyCharacteristicTextField(),f));
                        theView.familyComboBoxUpdate(theModel.getFamilyMap());
                        
                    } else
                    {
                        JOptionPane.showMessageDialog(theView, "Rodzina musi należeć do istniejącego typu");
                    }
                    break;
               
                case "species" :
                    if(theView.getCurrentSpeciesComboBoxSelectedValue().equals(""))
                    {
                        JOptionPane.showMessageDialog(theView, "Nie można edytować pustego wpisu");
                        break;
                    }
                    try {
                        p=Integer.parseInt(theView.getSpeciesLimbCountTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Ilość kończyn musi być liczbą");
                        break;
                    }
                    Family family = theModel.getFamilyItem(theView.getFamilyComboBoxSelectedValue());
                    if(family != null)
                    {
                        if((theView.getSpeciesComboBoxSelectedValue()[0] == "") || (theView.getSpeciesComboBoxSelectedValue()[1] == ""))
                            theModel.addItemToSpeciesMap(new Species(family, theView.getSpeciesNameTextField(), theView.getSpeciesDiscoveryDateTextField(), p, theView.getSpeciesRepresentantTextField()));
                        else 
                            theModel.addItemToSpeciesMap(new Hybrid(theModel.getFamilyItem(theView.getFamilyComboBoxSelectedValue()), theView.getSpeciesNameTextField(), theView.getSpeciesDiscoveryDateTextField(), p, theView.getSpeciesRepresentantTextField(),theView.getSpeciesComboBoxSelectedValue()));
                        theView.speciesComboBoxUpdate(theModel.getSpeciesMap());
                    } else
                        JOptionPane.showMessageDialog(theView, "Gatunek musi należeć do istniejącej rodziny");
                  
                    break;
                default: 
                    JOptionPane.showMessageDialog(theView, "Proszę wybrać rodzaj wpisu");
                    break;
            }
            loading = false;
        }
    }
    
    /**
     *Action listener for Add button in Add tab
     */
    public class AddButtonActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            loading = true;
            int p;
            String checkedRadioBox = theView.getCheckedRadioButton();
            switch (checkedRadioBox) {
                case "phylum":
                    
                    try {
                        p=Integer.parseInt(theView.getPhylumPopulationTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Populacja musi być liczbą");
                        break;
                    }
                    theModel.addItemToPhylumMap(new Phylum(theView.getPhylumNameTextField(),Integer.parseInt(theView.getPhylumPopulationTextField()),theView.getPhylumAnatomyTextField()));
                    theView.phylumComboBoxUpdate(theModel.getPhylumMap());
                    break;
                case "family" :
                    float f;
                    try {
                        f=Float.parseFloat(theView.getFamilyAverageLimbCountTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Średnia ilość kończyn musi być liczbą");
                        break;
                    }
                    Phylum phylum = theModel.getPhylumItem(theView.getPhylumComboBoxSelectedValue());
                    if(phylum != null)
                    {
                        theModel.addItemToFamilyMap(new Family(phylum,theView.getFamilyNameTextField(),theView.getFamilyCharacteristicTextField(),f));
                        theView.familyComboBoxUpdate(theModel.getFamilyMap());
                        
                    } else
                    {
                        JOptionPane.showMessageDialog(theView, "Rodzina musi należeć do istniejącego typu");
                    }
                    break;
               
                case "species" :
                    try {
                        p=Integer.parseInt(theView.getSpeciesLimbCountTextField());
                    }
                    catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(theView, "Ilość kończyn musi być liczbą");
                        break;
                    }
                    Family family = theModel.getFamilyItem(theView.getFamilyComboBoxSelectedValue());
                    if(family != null)
                    {
                        if((theView.getSpeciesComboBoxSelectedValue()[0] == "") || (theView.getSpeciesComboBoxSelectedValue()[1] == ""))
                            theModel.addItemToSpeciesMap(new Species(family, theView.getSpeciesNameTextField(), theView.getSpeciesDiscoveryDateTextField(), p, theView.getSpeciesRepresentantTextField()));
                        else 
                            theModel.addItemToSpeciesMap(new Hybrid(theModel.getFamilyItem(theView.getFamilyComboBoxSelectedValue()), theView.getSpeciesNameTextField(), theView.getSpeciesDiscoveryDateTextField(), p, theView.getSpeciesRepresentantTextField(),theView.getSpeciesComboBoxSelectedValue()));
                        theView.speciesComboBoxUpdate(theModel.getSpeciesMap());
                    } else
                        JOptionPane.showMessageDialog(theView, "Gatunek musi należeć do istniejącej rodziny");
                  
                    break;
                default: 
                    JOptionPane.showMessageDialog(theView, "Proszę wybrać rodzaj wpisu");
                    break;
            }
            loading = false;
               
        }
        
    }
    
    /**
     *Action listener for Save button in save/load tab. Converts data into xml and saves it to 3 separate files in selected folder.
     */
    public class SaveButtonActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String phylumXml;
            String familyXml;
            String speciesXml;
            XStream xStream = new XStream(new DomDriver());
            xStream.registerConverter(new PhylumHashMapConverter());
            xStream.registerConverter(new FamilyHashMapConverter());
            xStream.registerConverter(new SpeciesHashMapConverter());
            phylumXml = xStream.toXML(theModel.getPhylumMap());
            familyXml = xStream.toXML(theModel.getFamilyMap());
            speciesXml = xStream.toXML(theModel.getSpeciesMap());
            File baseFolder = theView.chooseFolder();
            phylumFile = new File(baseFolder.toString() + "/phylum.xml");
            familyFile = new File(baseFolder.toString() + "/family.xml");
            speciesFile = new File(baseFolder.toString() + "/species.xml");
            
            try {
                phylumFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                familyFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                speciesFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            Writer phylumWriter = null;
            Writer familyWriter = null;
            Writer speciesWriter = null;
            try {
                phylumWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(phylumFile)));
                familyWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(familyFile)));
                speciesWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(speciesFile)));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                phylumWriter.write(phylumXml);
                phylumWriter.flush();
                familyWriter.write(familyXml);
                familyWriter.flush();
                speciesWriter.write(speciesXml);
                speciesWriter.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     *Loads data from selected folder
     */
    public class LoadButtonActionListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String phylumXml = null;
            String familyXml = null;
            String speciesXml = null;
            HashMap<String, Phylum> phylumHM = new HashMap<String, Phylum>();
            HashMap<String, Family> familyHM = new HashMap<String, Family>();
            HashMap<String, Species> speciesHM = new HashMap<String, Species>();
            XStream xStream = new XStream(new DomDriver());
            
            File baseFolder = theView.chooseFolder();
            phylumFile = new File(baseFolder.toString() + "/phylum.xml");
            familyFile = new File(baseFolder.toString() + "/family.xml");
            speciesFile = new File(baseFolder.toString() + "/species.xml");
            BufferedReader phylumReader = null;
            BufferedReader familyReader = null;
            BufferedReader speciesReader = null;
            try {
            phylumReader = new BufferedReader(new InputStreamReader(new FileInputStream(phylumFile)));
            familyReader = new BufferedReader(new InputStreamReader(new FileInputStream(familyFile)));
            speciesReader = new BufferedReader(new InputStreamReader(new FileInputStream(speciesFile)));
            } catch (FileNotFoundException ex)
            {
                
            }
            
            try {
            String line = phylumReader.readLine();
            phylumXml = line;
            line = phylumReader.readLine();
            while(line != null)
            {
                phylumXml = phylumXml + line;
                line = phylumReader.readLine();
            }
            line = familyReader.readLine();
            familyXml = line;
            line = familyReader.readLine();
            while(line != null)
            {
                familyXml = familyXml + line;
                line = familyReader.readLine();
            }
            line = speciesReader.readLine();
            speciesXml = line;
            line = speciesReader.readLine();
            while(line != null)
            {
                speciesXml = speciesXml + line;
                line = speciesReader.readLine();
            }
            } catch(IOException ex)
            {
                System.out.println("Błąd podczas wczytywania");
            }
    
            phylumHM = (HashMap<String, Phylum>) xStream.fromXML(phylumXml);
            familyHM = (HashMap<String, Family>) xStream.fromXML(familyXml);
            speciesHM = (HashMap<String, Species>) xStream.fromXML(speciesXml);
            
            theModel.setPhylumMap(phylumHM);
            theModel.setFamilyMap(familyHM);
            theModel.setSpeciesMap(speciesHM);
            theView.phylumComboBoxUpdate(theModel.getPhylumMap());
            theView.familyComboBoxUpdate(theModel.getFamilyMap());
            theView.speciesComboBoxUpdate(theModel.getSpeciesMap());
        }
    }
    
    /**
     *Performs search action on all program data
     */
    public class SearchButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            loading = true;
            String regexp = theView.getSearchTextField();
            if(!regexp.equals(""))
                {
                    regexp = this.transformRegexp(regexp);
                    HashMap<String, Species> speciesResults;
                    if(e.getSource() == theView.getSearchButton())
                    {
                        speciesResults = theModel.searchInSpeciesMap(regexp);
                    } else
                    {
                        speciesResults = theModel.searchByFamilyName(regexp);
                    }
                    theView.searchResultsComboBoxUpdate(speciesResults);
                
                } else
                {
                    JOptionPane.showMessageDialog(theView, "Klucz wyszukiwanai nie może być pusty");
                }
            loading = false;
           
            
            }

        /**
         *Translates standard wildcards-like regular expressions to expressions that Java can understand and fixes potential regexp errors 
         * @param regexp
         * @return 
         */
        public String transformRegexp(String regexp)
    {
        String suffix = "";
        if(regexp.endsWith("*"))
        {
            suffix = "(.*)";
        } else if(regexp.endsWith("?"))
        {
            suffix = "(.)";
        }
            
            if(regexp.contains("*"))
            {
                String[] splited = regexp.split("\\*");
                regexp = splited[0];
                for(int i=0; i<splited.length-1; i++)
                {   
                    regexp = regexp + "(.*)" + splited[i];
                }
            
            }
            if(regexp.contains("?"))
            {
                String[] splited = regexp.split("\\?");
                regexp = splited[0];
                for(int i=1; i<splited.length; i++)
                {
                    regexp = regexp + "(.)" + splited[i];
                }
            }
        regexp = regexp + suffix;
        return regexp;
    }
    
    }
    
    /**
     *Action listener for Name combobox
     */
    public class NameCBActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(!loading)
            {
            loading = true;
            String checkedRadioButton = theView.getCheckedRadioButton();
            switch(checkedRadioButton) {
                
                    case "phylum":
                        if(theView.getPhylumComboBoxSelectedValue()!="")
                        {
                            Phylum phylum = theModel.getPhylumItem(theView.getPhylumComboBoxSelectedValue());
                            theView.setPhylumNameTextField(phylum.getPhylumName());
                            theView.setPhylumPopulationTextField(Integer.toString(phylum.getPopulation()));
                            theView.setPhylumAnatomyTextField(phylum.getAnatomy());
                            break;
                        } else
                            break;
                        
                    case "family":
                        if(theView.getFamilyComboBoxSelectedValue() != "")
                        {
                            Family family = theModel.getFamilyItem(theView.getFamilyComboBoxSelectedValue());
                            theView.setPhylumComboBoxSelectedValue(family.getPhylum().getPhylumName());
                            theView.setFamilyNameTextField(family.getFamilyName());
                            theView.setFamilyCharacteristicTextField(family.getCharacteristic());
                            theView.setFamilyAverageLimbCountTextField(Float.toString(family.getAverageLimbCount()));
                            break;
                        } else
                            break;
                    case "species":
                        if(theView.getCurrentSpeciesComboBoxSelectedValue() != "")
                        {
                            if(theModel.getSpeciesItem(theView.getCurrentSpeciesComboBoxSelectedValue()).getClass() == Species.class)
                            {
                                Species species = theModel.getSpeciesItem(theView.getCurrentSpeciesComboBoxSelectedValue());
                                theView.setFamilyComboBoxSelectedValue(species.getFamily().getFamilyName());
                                theView.setSpeciesDiscoveryDateTextField(species.getDiscoveryDate());
                                theView.setSpeciesLimbCountTextField(Integer.toString(species.getLimbCount()));
                                theView.setSpeciesName1ComboBoxSelectedValue("");
                                theView.setSpeciesName2ComboBoxSelectedValue("");
                                theView.setSpeciesNameTextField(species.getSpeciesName());
                                theView.setSpeciesRepresentantTextField(species.getRepresentantName());
                            
                            } else
                            {
                                Hybrid species =(Hybrid) theModel.getSpeciesItem(theView.getCurrentSpeciesComboBoxSelectedValue());
                                theView.setFamilyComboBoxSelectedValue(species.getFamily().getFamilyName());
                                theView.setSpeciesDiscoveryDateTextField(species.getDiscoveryDate());
                                theView.setSpeciesLimbCountTextField(Integer.toString(species.getLimbCount()));
                                theView.setSpeciesName1ComboBoxSelectedValue(species.getSpeciesNames()[0]);
                                theView.setSpeciesName2ComboBoxSelectedValue(species.getSpeciesNames()[1]);
                                theView.setSpeciesNameTextField(species.getSpeciesName());
                                theView.setSpeciesRepresentantTextField(species.getRepresentantName());
                            }
                            break;
                        } else
                            break;
                    
                 }
            loading = false;
            }
        }
        
    }  
    
    /**
    *Shows all species existing in the program
    */
    public class ShowAllButtonActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                loading = true;
                theView.searchResultsComboBoxUpdate(theModel.getSpeciesMap());
                loading = false;
            }
            
        }

    /**
     *Performs search by limb count
     */
    public class SearchByLimbCountButtonActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                loading = true;
                int limbCount;
                try 
                {
                    limbCount = Integer.parseInt(theView.getSearchTextField());
                    theView.searchResultsComboBoxUpdate(theModel.searchByLimbCount(limbCount));
                } catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(theView, "Ilość kończyn musi być liczbą całkowitą");
                }
                loading = false;
            }
            
        }
    
}