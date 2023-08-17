/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsu.fpmi.edupract;

import java.beans.*;
/**
 *
 * @author alexe
 */
public class ButtonClassEditor extends PropertyEditorSupport  {
   @Override
    public String[] getTags() {
	return new String[] { "Click", "Dont't click", "Button" };
    }
    
    @Override
    public boolean supportsCustomEditor() { return true; }
    
    @Override
    public void setAsText(String s) {
	if (s.equals(getTags()[0])) setValue(getTags()[0]);
	else if (s.equals(getTags()[1])) setValue(getTags()[1]);
	else if (s.equals(getTags()[2])) setValue(getTags()[2]);
	else throw new IllegalArgumentException(s);
    }
    
    /** This is an important method for code generation. */
    @Override
    public String getJavaInitializationString() {
	return "\""+ (String) getValue() + "\"";
    } 
}
