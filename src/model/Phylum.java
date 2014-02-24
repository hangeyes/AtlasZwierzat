package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangeyes
 */
public class Phylum {
    
    private final String phylumName;
    private int population;
    private String anatomy;
    
    /**
     *
     * @param name
     * @param population
     * @param anatomy
     */
    public Phylum(String name, int population, String anatomy) {
        this.phylumName = name;
        this.population = population;
        this.anatomy = anatomy;    
    }

    /**
     * @return the name
     */
    public String getPhylumName() {
        return phylumName;
    }

    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * @return the anatomy
     */
    public String getAnatomy() {
        return anatomy;
    }

    /**
     * @param anatomy the anatomy to set
     */
    public void setAnatomy(String anatomy) {
        this.anatomy = anatomy;
    }
    
    
}
