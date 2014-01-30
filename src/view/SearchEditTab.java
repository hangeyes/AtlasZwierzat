/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hangeyes
 */
public class SearchEditTab extends JPanel{
    
    JTextField searchTextField;
    JButton searchButton;
    JButton showAllButton;
    JButton searchByFamilyButton;
    JButton searchByLimbCountButton;
    JLabel nameLabel = new JLabel("");
    JLabel species1Label = new JLabel("");
    JLabel species2Label = new JLabel("");
    JLabel familyNameLabel = new JLabel("");
    JLabel limbCountLabel = new JLabel("");
    JLabel representantLabel = new JLabel("");
    JLabel discoveryDateLabel = new JLabel("");
    JComboBox searchResultsCB = new JComboBox();
    
    
    public SearchEditTab()
    {
        searchTextField = new JTextField("Wpisz nazwę");
        searchButton = new JButton("Wyszukaj");
        showAllButton = new JButton("Pokaż wszystko");
        searchByFamilyButton = new JButton("Wyszukaj po rodzinie");
        searchByLimbCountButton = new JButton("Wyszukaj po liczbie kończyn");
        
        
        
        this.add(searchButton);
        this.add(showAllButton);
        this.add(searchByFamilyButton);
        this.add(searchByLimbCountButton);
        this.add(searchTextField);
        this.add(searchResultsCB);
        this.add(nameLabel);
        this.add(familyNameLabel);
        this.add(species1Label);
        this.add(species2Label);
        this.add(limbCountLabel);
        this.add(discoveryDateLabel);
        this.add(representantLabel);
    }
}
