/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsu.fpmi.edupract;

import java.beans.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author alexe
 */
public class ListClassEditor extends PropertyEditorSupport {
    @Override
    public String[] getTags() {
        
	return new String[] { "Item1, Item2, Item3", "1, 2, 3", "Option1, Option2, Option3" };
    }
    
    DefaultListModel<String> i1 = new DefaultListModel<String>() ;
    DefaultListModel<String> i2 = new DefaultListModel<String>() ;
    DefaultListModel<String> i3 = new DefaultListModel<String>() ;
    
    @Override
    public boolean supportsCustomEditor() { return true; }
    
    @Override
    public void setAsText(String s) {
        i1.addElement("Item1");
        i1.addElement("Item2");
        i1.addElement("Item3");
        i2.addElement("1");
        i2.addElement("2");
        i2.addElement("3");
        i3.addElement("Option1");
        i3.addElement("Option2");
        i3.addElement("Option3");
	if (s.equals(getTags()[0])) setValue((ListModel<String>)i1);
	else if (s.equals(getTags()[1])) setValue((ListModel<String>)i2);
	else if (s.equals(getTags()[2])) setValue((ListModel<String>)i3);
	else throw new IllegalArgumentException(s);
    }
    
    /** This is an important method for code generation. */
    @Override
    public String getJavaInitializationString() {
	return "\""+ (String) getValue() + "\"";
    } 
}
