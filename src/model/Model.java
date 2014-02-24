/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Hangeyes
 */
public class Model {
    
    private HashMap<String, Phylum> phylumMap = new HashMap<String, Phylum>();
    private HashMap<String, Family> familyMap = new HashMap<String, Family>();
    private HashMap<String, Species> speciesMap = new HashMap<String, Species>();
    
    /**
     *
     */
    public Model() {
        
    }
    
    /**
     *
     * @return the phylumList
     */
    public HashMap<String, Phylum> getPhylumMap() {
        return phylumMap;
    }

    /**
     * @return the familyList
     */
    public HashMap<String, Family> getFamilyMap() {
        return familyMap;
    }

    /**
     * @return the speciesList
     */
    public HashMap<String, Species> getSpeciesMap() {
        return speciesMap;
    }
    
    /**
     *
     * @param map
     */
    public void setPhylumMap(HashMap<String, Phylum> map)
    {
        this.phylumMap = map;
        
    }
    
    /**
     *
     * @param map
     */
    public void setFamilyMap(HashMap<String, Family> map)
    {
        this.familyMap = map;
    }
    
    /**
     *
     * @param map
     */
    public void setSpeciesMap(HashMap<String, Species> map)
    {
        this.speciesMap = map;
    }
    

    /**
     *Adds an item to PhylumMap
     */
    
    
    public void addItemToPhylumMap(Phylum item) {
        this.phylumMap.put(item.getPhylumName(), item);
    }
    
    /**
     *Adds an item to FamilyMap
     */
    public void addItemToFamilyMap(Family item) {
        this.familyMap.put(item.getFamilyName(), item);
    }
    
    /**
     *Adds an item to SpeciesMap
     */
    public void addItemToSpeciesMap(Species item) {
        this.speciesMap.put(item.getSpeciesName(), item);
    }

    /**
     *
     * @param name
     * @return
     */
    public Phylum getPhylumItem(String name)
    {
            return this.phylumMap.get(name);   
    }

    /**
     *
     * @param name
     * @return
     */
    public Family getFamilyItem(String name)
    {
            return this.familyMap.get(name);
    }
    
    /**
     *
     * @param name
     * @return
     */
    public Species getSpeciesItem(String name)
    {
            return this.speciesMap.get(name);
    }
    
    /**
    *Searches for item by key
    */
    public HashMap<String, Phylum> searchInPhylumMap(String search)
    {
        HashMap<String, Phylum> resultHashMap = new HashMap<String, Phylum>();
        
        Iterator<String> key = this.phylumMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            if(i.matches(search))
                resultHashMap.put(i, this.phylumMap.get(i));
        }
        return resultHashMap;
    }
    
    /**
    *Searches for item by key
    */
    public HashMap<String, Family> searchInFamilyMap(String search)
    {
        HashMap<String, Family> resultHashMap = new HashMap<String, Family>();
        
        Iterator<String> key = this.familyMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            if(i.matches(search))
                resultHashMap.put(i, this.familyMap.get(i));
        }
        return resultHashMap;
    }
    
    /**
    *Searches for item by key
    */
    public HashMap<String, Species> searchInSpeciesMap(String search)
    {
        HashMap<String, Species> resultHashMap = new HashMap<String, Species>();
        
        Iterator<String> key = this.speciesMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            if(i.matches(search))
                resultHashMap.put(i, this.speciesMap.get(i));
        }
        return resultHashMap;
    }
    
    /**
    *Removes an item with a specified key
    */
    public void removeItemFromPhylumHashMap(String key)
    {
        this.phylumMap.remove(key);
    }
    
    /**
    *Removes an item with a specified key
    */
    public void removeItemFromFamilyHashMap(String key)
    {
        this.familyMap.remove(key);
    }
    
    /**
    *Removes an item with a specified key
    */
    public void removeItemFromSpeciesHashMap(String key)
    {
        this.speciesMap.remove(key);
    }
    
    /**
    *Searches for item by family name
    */
    public HashMap<String, Species> searchByFamilyName (String family)
    {
        HashMap<String, Species> resultHashMap = new HashMap<String, Species>();
        
        Iterator<String> key = this.speciesMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            if(this.speciesMap.get(i).getFamily().getFamilyName().matches(family))
                resultHashMap.put(i, this.speciesMap.get(i));
        }
        return resultHashMap;
    }
    
    /**
    *Searches for item by limb count
    */
    public HashMap<String, Species> searchByLimbCount (int limbCount)
    {
        HashMap<String, Species> resultHashMap = new HashMap<String, Species>();
        
        Iterator<String> key = this.speciesMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            if(this.speciesMap.get(i).getLimbCount() == limbCount)
                resultHashMap.put(i, this.speciesMap.get(i));
        }
        return resultHashMap;
    }

}
