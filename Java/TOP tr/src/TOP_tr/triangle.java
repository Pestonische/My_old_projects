package TOP_tr;

public class triangle 
{
   double x;
   double y;
   double z;
   
	   
   triangle( double _x, double _y, double _z)
   {
	  	x=_x;
	  	y=_y;
	  	z=_z;
   }
   public double Perimeter(  double _x, double _y, double _z) 
	{
		
		double perimeter=0;
		
		perimeter+=_x+_y+_z;
		
		return perimeter;
   }
	
	
	public double Area(double _x, double _y, double _z)
	{
		double area=0;
		double p =_x+_y+_z;
		
		area=Math.sqrt((p/2)*(p/2-_x)*(p/2 -_y)*(p/2-_z));
		
		return area;
	}
	public boolean TREE(double _x, double _y, double _z)
	{
		if(_x==_y && _y==_z)
			return true;
		
		return false;
	}
   
}
