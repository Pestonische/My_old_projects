package TOP_tr;

import java.util.Scanner;

public class TOP_tr {

	public static void main(String[] args) {
		
		double a,b,c;
		
		
		Scanner in = new Scanner( System.in );
		 a = in.nextDouble();
		 b = in.nextDouble();
		 c = in.nextDouble();
		 if(!(a<b+c && b<a+c && c<a+b))
			{
				System.out.println("не треугольник");
				
			}
		 else 
		 {
		 if(a==b && a==c)
			{
				System.out.println("равносторонний");
			}
		 else if(a==b&&a!=c)
		 {
			 System.out.println("равнобедренный");
		 }
		 else
		 {
			 System.out.println("разносторонний");
		 }
		 
		triangle t=new triangle(a,b,c);
		System.out.println(t.Perimeter(t.x, t.y, t.z));
		System.out.println(t.Area(t.x, t.y, t.z));
		
		if(t.TREE(t.x, t.y, t.z))
		System.out.println("да");
		 }
		

	}

}
