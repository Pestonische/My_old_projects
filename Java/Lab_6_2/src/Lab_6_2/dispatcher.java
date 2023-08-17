package Lab_6_2;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class dispatcher implements Serializable
{
	cars c;
	drivers d;
	int request;
	boolean valid;
	int i;
    String s;
    public final Date data = new Date();
	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(
				DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
	    String dateOut = dateFormatter.format(data);
		return dateOut;
	}
	dispatcher(int _request, String _d, boolean _valid, int _c) throws Exception
	{
		
		c= new cars(_c);
		i=_c;
		d= new drivers( _d, _valid, c);
        s=_d;
		if(_request <= 0)
        {
            throw new Exception("Номер заказа должен быть положительным");
        }
        else 
        {
		request=_request;
        }
		valid = _valid;
	}
	public void in_flight_drivers(){
		this.valid = true;
		this.d.in_flight();
    }
	public void no_in_flight_drivers()
	{		
		this.valid = false;
		this.d.no_in_flight();
    } 
	public void _repairs_car()
	{
		this.d.repairs_car();
		System.out.println("Машина номер " + i+" отправлена в ремонт.");
    }

    public void _renovated_car(){
    	this.d.renovated_car();
    }
    public void completed()
    {
    	if(this.valid == false)
    	{
    		this.c.in_flight();
        	
        	this.d.in_flight();
        	
        	System.out.println("Заказ номер "+ this.request +" отменен, водитель снят с заказа."); 
    	}
    	else {
    	this.c.in_flight();
    	
    	this.d.in_flight();
    	
    	System.out.println("Заказ номер "+ this.request +" выполнен.");  
    	}
    }
    public String toString() {
    	 return new String(AppLocale.getString(AppLocale.nomer) + ": " + String.valueOf(request) + " " +
                 AppLocale.getString( AppLocale.name) + ": " + s + " " +
                 AppLocale.getString( AppLocale.nomer_car) + ": " + String.valueOf(i) + " " +
                 AppLocale.getString( AppLocale.data) + ": " + getCreationDate());
	}
    
    
}
