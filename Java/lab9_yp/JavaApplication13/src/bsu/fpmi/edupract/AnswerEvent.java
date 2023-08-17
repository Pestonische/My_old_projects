/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsu.fpmi.edupract;

/**
 *
 * @author Asus_Notebook
 */
public class AnswerEvent extends java.util.EventObject {

    public static final int what = 0;  // Button constants
    protected int id;                             // Which item was chosen?
    protected String text;

    public AnswerEvent(Object source, int id, String text) {
        super(source);
        this.id = id;
        this.text = text;
    }

    public int getID() {
        return id;
    }             // Return the item{

    public String getText() {
        return this.text;
    }

}
