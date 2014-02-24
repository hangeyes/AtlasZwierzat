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
import model.Family;

/**
 *
 * Class used in converting FamilyHashMap from Model into xml and reversing it. For more details check xstream library documentation.
 */
public class FamilyHashMapConverter implements Converter{
    
    /**
     *
     * @param o
     * @param writer
     * @param mc
     */
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        HashMap<String, Family> familyHashMap = (HashMap<String, Family>) o;
        Iterator<String> key = familyHashMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            Family family = familyHashMap.get(i);
            writer.startNode("family");
                writer.addAttribute("key", i);
                mc.convertAnother(family);
            writer.endNode();
             
        }
    }

    /**
     *
     * @param reader
     * @param uc
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        HashMap<String, Family> familyHashMap = new HashMap<String, Family>();
        while(reader.hasMoreChildren())
        {
            reader.moveDown();
            String key = reader.getAttribute("key");
            Family family = (Family) uc.convertAnother(familyHashMap,Family.class);
            reader.moveUp();
            familyHashMap.put(key, family);
            
            
        }
        return familyHashMap;
    }

    /**
     *
     * @param type
     * @return
     */
    @Override
    public boolean canConvert(Class type) {
        return FamilyHashMapConverter.class == type;
    }
}
