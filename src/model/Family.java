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
public class Family {
    
    private final String familyName;
    private String characteristic;
    private float averageLimbCount;
    private Phylum phylum;

    /**
     *
     * @param phylum
     * @param familyName
     * @param characteristic
     * @param averageLimbCount
     */
    public Family(Phylum phylum, String familyName, String characteristic, float averageLimbCount) {
        this.phylum = phylum;
        this.familyName = familyName;
        this.characteristic = characteristic;
        this.averageLimbCount = averageLimbCount;
        
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @return the characteristic
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * @param characteristic the characteristic to set
     */
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * @return the averageLimbCount
     */
    public float getAverageLimbCount() {
        return averageLimbCount;
    }

    /**
     * @param averageLimbCount the averageLimbCount to set
     */
    public void setAverageLimbCount(float averageLimbCount) {
        this.averageLimbCount = averageLimbCount;
    }

    /**
     * @return the phylum
     */
    public Phylum getPhylum() {
        return phylum;
    }
    
}
