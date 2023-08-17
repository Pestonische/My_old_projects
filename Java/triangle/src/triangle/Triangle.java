package triangle;

public abstract class Triangle 
{	
    
	double x;
	double y;
	double z;
	
	
	Triangle( String...args )
	{
		x=Double.parseDouble(args[0]);
		y=Double.parseDouble(args[1]);
		z=Double.parseDouble(args[2]);		
	  	
    }
     Triangle( String str )
     {
    	
     }

     public abstract double Perimeter();
     public abstract double Area();
 
}
