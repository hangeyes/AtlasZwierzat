package model;

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
public class Hybrid extends Species{
    
    /*private String speciesName1;
    private String speciesName2;*/
    private String[] speciesNames = new String[2];

    /**
     *
     * @param family
     * @param hybridName
     * @param discoveryDate
     * @param limbCount
     * @param representantName
     * @param speciesNames
     */
    public Hybrid(Family family, String hybridName, String discoveryDate, int limbCount, String representantName, String speciesNames[]) {
        super(family, hybridName, discoveryDate, limbCount, representantName);
        this.speciesNames[0] = speciesNames[0];
        this.speciesNames[1] = speciesNames[1];
        //this.speciesName2 = speciesNames[1];
        /*this.speciesName1 = this.speciesNames[0];
        this.speciesNames[1] = this.speciesName2;*/
        
    }
    
    /**
     *
     * @return
     */
    public String[] getSpeciesNames() {
        return this.speciesNames;
    }
    
    /**
     *
     * @param speciesName1
     * @param speciesName2
     */
    public void setSpeciesNames(String speciesName1, String speciesName2) {
        /*this.speciesName1 = speciesName1;
        this.speciesName2 = speciesName2;*/
        this.speciesNames[0] = speciesName1;
        this.speciesNames[1] = speciesName2;
    }
}
