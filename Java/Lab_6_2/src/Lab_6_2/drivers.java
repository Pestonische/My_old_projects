package Lab_6_2;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class drivers implements Serializable
{
	private final String name;
	private boolean valid = false;
    private boolean in_flight = false;
    private final transient Date data;
    cars c;
    
    drivers(String _name, boolean _valid, cars _c)
    {
    	name=_name;
    	valid=_valid;
    	c=_c;
    	data=new Date();
    }
    
    public void in_flight(){
        this.in_flight = true;
    }

    public void no_in_flight(){
    	this.in_flight = false;
    } 
    public void repairs_car()
    {
    	this.c.repairs();
    }

    public void renovated_car()
    {
        this.c.renovated();
    }

}