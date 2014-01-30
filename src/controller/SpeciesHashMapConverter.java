/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import model.Family;
import model.Hybrid;
import model.Species;

/**
 *
 * @author Hangeyes
 */
public class SpeciesHashMapConverter implements Converter{

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        HashMap<String, Species> speciesHashMap = (HashMap<String, Species>) o;
        Iterator<String> key = speciesHashMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            Class clazz = Hybrid.class;
            writer.startNode("species");
            if(clazz == speciesHashMap.get(i).getClass())
            {
                Hybrid hybrid;
                hybrid =(Hybrid) speciesHashMap.get(i);
                writer.addAttribute("type", "hybrid");
                writer.addAttribute("key", i);
                mc.convertAnother(hybrid);
            } else {
                Species species;
                species = speciesHashMap.get(i);
                writer.addAttribute("key", i);
                mc.convertAnother(species);
            }
            writer.endNode();
             
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        HashMap<String, Species> speciesHashMap = new HashMap<String, Species>();
        while(reader.hasMoreChildren())
        {
            reader.moveDown();
            if(reader.getAttribute("type").equals("hybrid"))
            {
                String key = reader.getAttribute("key");
                Hybrid hybrid = (Hybrid) uc.convertAnother(speciesHashMap, Hybrid.class);
                speciesHashMap.put(key, hybrid);
            } else {
                String key = reader.getAttribute("key");
                Species species = (Species) uc.convertAnother(speciesHashMap, Species.class);
                speciesHashMap.put(key, species);
            }
            reader.moveUp();
            
     
        }
        return speciesHashMap;
    }

    @Override
    public boolean canConvert(Class type) {
        return SpeciesHashMapConverter.class == type;
    }
    
}
