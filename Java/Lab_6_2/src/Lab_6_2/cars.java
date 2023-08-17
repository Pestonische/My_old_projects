package Lab_6_2;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class cars implements Serializable
{
	private final int cars_number;
	private boolean repairs = false;
    private boolean in_flight = false;
    private final transient Date data;
    
    cars(int _cars_number)throws Exception
    {
        if(_cars_number <= 0)
        {
            throw new Exception("Номер машины должен быть положительным");
        }
        else 
        {
        	cars_number = _cars_number;
        }   
        data=new Date();
    }
    
    public void repairs(){
        this.repairs = true;
    }

    public void renovated(){
        this.repairs = false;
    }
    public void in_flight()
    {
        this.in_flight = true;
    }

    public void no_in_flight()
    {
        this.in_flight = false;
    }

    public int getСars_number(){
        return cars_number;
    }
    
}
