package model;


import model.Family;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangeyes
 */
public class Species{

    private final String speciesName;
    private String discoveryDate;
    private int limbCount;
    private String representantName;
    private Family family;
    
    /**
     *
     * @param family
     * @param speciesName
     * @param discoveryDate
     * @param limbCount
     * @param representantName
     */
    public Species(Family family, String speciesName, String discoveryDate, int limbCount, String representantName) {
        this.family = family;
        this.speciesName = speciesName;
        this.discoveryDate = discoveryDate;
        this.limbCount = limbCount;
        this.representantName = representantName;
        
    }

    /**
     * @return the speciesName
     */
    public String getSpeciesName() {
        return speciesName;
    }

    /**
     * @return the discoveryDate
     */
    public String getDiscoveryDate() {
        return discoveryDate;
    }

    /**
     * @param discoveryDate the discoveryDate to set
     */
    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    /**
     * @return the limbCount
     */
    public int getLimbCount() {
        return limbCount;
    }

    /**
     * @return the representantName
     */
    public String getRepresentantName() {
        return representantName;
    }

    /**
     * @param representantName the representantName to set
     */
    public void setRepresentantName(String representantName) {
        this.representantName = representantName;
    }

    /**
     * @return the family
     */
    public Family getFamily() {
        return family;
    }

    /**
     * @param family the family to set
     */
    public void setFamily(Family family) {
        this.family = family;
    }
    
}
