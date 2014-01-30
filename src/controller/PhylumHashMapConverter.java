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
import model.Phylum;

/**
 *
 * @author Hangeyes
 */
public class PhylumHashMapConverter implements Converter{

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        HashMap<String, Phylum> phylumHashMap = (HashMap<String, Phylum>) o;
        Iterator<String> key = phylumHashMap.keySet().iterator();
        while(key.hasNext())
        {
            String i = key.next();
            Phylum phylum = phylumHashMap.get(i);
            writer.startNode("phylum");
                writer.addAttribute("key", i);
                mc.convertAnother(phylum);
            writer.endNode();
             
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        HashMap<String, Phylum> phylumHashMap = new HashMap<String, Phylum>();
        while(reader.hasMoreChildren())
        {
            reader.moveDown();
            String key = reader.getAttribute("key");
            Phylum phylum = (Phylum) uc.convertAnother(phylumHashMap,Phylum.class);
            reader.moveUp();
            phylumHashMap.put(key, phylum);
            
            
        }
        return phylumHashMap;
    }

    @Override
    public boolean canConvert(Class type) {
        return PhylumHashMapConverter.class == type;
    }
    
    
}
