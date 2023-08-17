package lab_8;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.Serializable;



public class Business_Firm implements Serializable
{
	// class release version:
    private static final long serialVersionUID = 1L;
    // areas with prompts:
    String toy_code; 			
    static final String P_toy_code = "Код игрушки";
    String name_toy;				
    static final String P_name_toy = "Имя игрушки";
    String age_limit;				
    static final String P_age_limit = "Возрастные ограничения";
    double price;
    static final String P_price = "Цена"; 
    int quantity;			
    static final String P_quantity = "Количество в наличии";
    String receipt_date;			
    static final String P_receipt_date = "Дата поступления";
    String provider;				
    static final String P_provider = "Поставщик";
	
    // validation methods:
    static Boolean valid_toy_code( String str ) {
        int i = 0, ndig = 0;
        for ( ; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if ( Character.isDigit(ch) ) {
                ndig++;
                continue;
            }
            if ( ch != ' ' ) {
                return false;
            }				
        }
        return (ndig == 10 );
    }
    static Boolean valid_toy_number( String str ) {
        int i = 0;
        for ( ; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if ( Character.isDigit(ch) ) {                
                continue;
            }
            else {
                return false;
            }				
        }
        return true;
    }
    static Boolean valid_toy_double_number( String str ) {
        int i = 0;
        for ( ; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if ( Character.isDigit(ch) ) {                
                continue;
            }
            if ( ch != '.' ) {
                return false;
            }				
        }
        return true;
    }
    static Boolean valid_age_limit( String str ) {
        String[] s = str.split("-");
        if(s.length!=2)
        {
            return false;
        }
        if(Integer.parseInt(s[0]) > Integer.parseInt(s[1]))
        {
            return false;
        }
        int i = 0, ndig = 0;
        for ( ; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if ( Character.isDigit(ch) ) {
                ndig++;
                continue;
            }
            if ( ch == '-' ) {
                if(i== str.length()-1 || i==0)
                {
                     return false;
                }
            	ndig++;
                continue;
            }	
            else
            {
               return false;
            }
        }
        return (ndig == 3 || ndig == 4 || ndig == 5 || ndig == 7 || ndig == 6 );
    }
    
    private static GregorianCalendar curCalendar = new GregorianCalendar();
    static Boolean valid_receipt_date( String date ) {
        String[] s = date.split(":");
        if(s.length!=3)
        {
            return false;
        }
        if(s[0].length()!=2 || s[1].length()!=2 ||Integer.parseInt(s[0]) > 31 || Integer.parseInt(s[1])>12 )
        {
            return false;
        }
        for (int i = 0; i < s[0].length(); i++ ) {
            char ch = s[0].charAt(i);            
            if ( Character.isDigit(ch) ) {                
                continue;
            }
            else
            {
               return false;
            }                 
        }
        for (int i = 0; i < s[0].length(); i++ ) {
            char ch  = s[1].charAt(i);            
            if ( Character.isDigit(ch) ) {                
                continue;
            }	
            else
            {
               return false;
            }
        }
        int g = Integer.parseInt(s[2]);
        if(g < 2005 || g > curCalendar.get( Calendar.YEAR ))
        {
           return false;
        }
        return true;
    }
	
    public static Boolean nextRead( Scanner fin, PrintStream out ) {
        return nextRead( P_toy_code, fin, out );
    }
	
    static Boolean nextRead( final String prompt, Scanner fin, PrintStream out ) {
        out.print( prompt );
        out.print( ": " );
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static Business_Firm read( Scanner fin, PrintStream out ) 
            throws IOException {
        String str;
        Business_Firm toy = new Business_Firm();
        toy.toy_code = fin.nextLine();
        if ( Business_Firm.valid_toy_code( toy.toy_code )== false ) {
            throw new IOException("");
        }
        
        if ( ! nextRead( P_name_toy, fin, out ))           return null;
        toy.name_toy = fin.nextLine();
        
        if ( ! nextRead( P_age_limit, fin, out ))             return null;
        toy.age_limit = fin.nextLine();
        
        if ( Business_Firm.valid_age_limit( toy.age_limit )== false ) {
            throw new IOException("Wrong data!");
        }
        
        if ( ! nextRead( P_price, fin, out ))            return null;
        str = fin.nextLine();
         if ( Business_Firm.valid_toy_double_number(str) ==  false ) {
            throw new IOException("Wrong data!");
        }
         else{
        toy.price = Double.parseDouble(str);  
         }        
        
        if ( ! nextRead( P_quantity, fin, out ))        return null;
        str = fin.nextLine();
         if ( Business_Firm.valid_toy_number(str) ==  false ) {
            throw new IOException("Wrong data!");
        }
         else{
        toy.quantity = Integer.parseInt(str);
         }
         
        if ( ! nextRead( P_receipt_date, fin, out ))             return null;
        toy.receipt_date = fin.nextLine();
        
        if ( Business_Firm.valid_receipt_date(toy.receipt_date) ==  false ) {
            throw new IOException("Wrong data!");
        }        
        
        if ( ! nextRead( P_provider, fin, out ))       return null;
        toy.provider = fin.nextLine();
        return toy;
    }
		
    public Business_Firm() {
    }
	
    public static final String areaDel = "\n";

    public String toString() {
        return //new String (
        		toy_code + areaDel +
            name_toy + areaDel +
            age_limit + areaDel +
            price + areaDel +
            quantity + areaDel +
            receipt_date + areaDel +
            provider + areaDel			
	//)
	;
    }
    }