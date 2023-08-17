package Matrixs;

import java.util.Scanner;
import java.util.Random;

public class Matrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        if ( n <= 1 ) {
            System.err.println("Invalid n value (require: n > 1");
            System.exit( 1 );
        }
        int[][] a = new int [n][n];
        Random rnd = new Random();
        rnd.setSeed( System.currentTimeMillis() );

        int increase = 0, decrease = 0;

        System.out.println("Source matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = rnd.nextInt();
                a[i][j] = temp % (n + 1);
                System.out.print(a[i][j] + "  ");           
               }
            System.out.println();
            }
        
            System.out.println();
            
            boolean sum1 = true;
            boolean sum2 = true;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                	
            if(j==n-1 && i!=n-1)
            {
            	if(a[i][j]==a[i+1][0])
            	{
            		sum1=true;
            		sum2=true;
            	}
            if(a[i][j]>a[i+1][0])
            {
            	if(sum1)
     		   {
     			   decrease+=a[i][j];
     			   decrease+=a[i+1][0];
     			   sum1=false;
     			   sum2=true;
     		   }
     		   else
     		   {
     			  decrease+=a[i+1][0];
     		   }
            }
            if(a[i][j]<a[i+1][0])
            {
            	
            	if(sum2)
     		   {
         		   increase+=a[i][j];
         		  increase+=a[i+1][0];
         		   sum1=true;
         		   sum2=false;
     		   }
         	   else
     		   {
         		  increase+=a[i+1][0];
     		   }
            }
            }
            else if(j!=n-1)
            {
            	if(a[i][j]==a[i][j+1])
            	{
            		sum1=true;
            		sum2=true;
            	}
        	   if(a[i][j]>a[i][j+1])
               {
        		   if(sum1)
        		   {
        			   decrease+=a[i][j];
        			   decrease+=a[i][j+1];
        			   sum1=false;
        			   sum2=true;
        		   }
        		   else
        		   {
               	     decrease+=a[i][j+1];
        		   }
               }
               if(a[i][j]<a[i][j+1])
               {
            	   if(sum2)
        		   {
            		   increase+=a[i][j];
            		   increase+=a[i][j+1];
            		   sum1=true;
            		   sum2=false;
        		   }
            	   else
        		   {
               	     increase+=a[i][j+1];
        		   }
               }
            }
                }
            }
            System.out.print("Sum:");
            System.out.print(increase-decrease);
            System.exit(0);
        }
	}


