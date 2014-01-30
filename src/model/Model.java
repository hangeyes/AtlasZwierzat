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
    
    public Model() {
        //speciesMap.put("", null);
    }
    
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
    
    public void setPhylumMap(HashMap<String, Phylum> map)
    {
        this.phylumMap = map;
        
    }
    
    public void setFamilyMap(HashMap<String, Family> map)
    {
        this.familyMap = map;
    }
    
    public void setSpeciesMap(HashMap<String, Species> map)
    {
        this.speciesMap = map;
    }
    
    /*public Phylum[] phylumMapToArray() {
        return this.phylumMap.toArray(new Phylum[0]);
    }
    
    public Family[] familyListToArray() {
        return this.familyList.toArray(new Family[0]);
    }
    
    public Species[] speciesListToArray() {
        return this.speciesList.toArray(new Species[0]);
    }*/
    
    public void addItemToPhylumMap(Phylum item) {
        this.phylumMap.put(item.getPhylumName(), item);
    }
    
    public void addItemToFamilyMap(Family item) {
        this.familyMap.put(item.getFamilyName(), item);
    }
    
    public void addItemToSpeciesMap(Species item) {
        this.speciesMap.put(item.getSpeciesName(), item);
    }
    
    
    public Phylum getPhylumItem(String name)
    {
            return this.phylumMap.get(name);   
    }
    
     
    public Family getFamilyItem(String name)
    {
            return this.familyMap.get(name);
    }
    
    public Species getSpeciesItem(String name)
    {
            return this.speciesMap.get(name);
    }
    
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
    
    public void removeItemFromPhylumHashMap(String key)
    {
        this.phylumMap.remove(key);
    }
    
    public void removeItemFromFamilyHashMap(String key)
    {
        this.familyMap.remove(key);
    }
    
    public void removeItemFromSpeciesHashMap(String key)
    {
        this.speciesMap.remove(key);
    }
    
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
