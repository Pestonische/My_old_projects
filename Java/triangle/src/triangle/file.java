package triangle;
import java.util.Arrays;
public class file {
	static void sortAndPrint( Equilateral_Triangle[] pl, int sortBy )  {
       
    System.out.println( "----- Sorted by: " + Equilateral_Triangle.getSortByName(sortBy));
    Arrays.sort( pl, Equilateral_Triangle.getComparator(sortBy));
    System.out.printf( Equilateral_Triangle.format() );
    System.out.println();
    for( Equilateral_Triangle cnt : pl ) {
        System.out.println( Equilateral_Triangle.format( cnt ) );
    }
}
	public static void main(String[] args)
	{
			Equilateral_Triangle[] pl = new Equilateral_Triangle[6];
            pl[0] = new Equilateral_Triangle("4|зеленый|голубой");
            pl[1] = new Equilateral_Triangle("8|желтый|желтый");
            pl[2] = new Equilateral_Triangle("1|желтый|зеленый");
            pl[3] = new Equilateral_Triangle("5|желтый|коричневый");
            pl[4] = new Equilateral_Triangle("5","желтый","коричневый");
            pl[5]=new Equilateral_Triangle(pl[0].toString());
            sortAndPrint( pl, 0 );
            sortAndPrint( pl, 1 );
            sortAndPrint( pl, 2 );
                        
            for(int i=0; i<4;i++)
            {
		    System.out.println("Площадь "+ (i+1)+": "+pl[i].Area());
		    System.out.println("Периметр "+ (i+1)+": "+pl[i].Perimeter());
            }

	}

}
