/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laba_9;
import java.io.*;
import java.util.*;
/**
 *
 * @author alexe
 */
public class Serialization {
    static public String filename    = "BusinessFirmSerialization.dat";
    static public String filenameBak = "BusinessFirmSerialization.~dat";
    static public String idxname     = "BusinessFirmSerialization.idx";
    static public String idxnameBak  = "BusinessFirmSerialization.~idx";
    
    private static PrintStream toyOut = System.out;
		
	    static Business_Firm readBusiness_Firm( Scanner fin ) throws IOException {	
	        return Business_Firm.nextRead( fin, toyOut ) 
	                ? Business_Firm.read( fin, toyOut ) : null;
	    }

	    private static void deleteBackup() {
	        new File( filenameBak ).delete();
	        new File( idxnameBak ).delete();				
	    }
		
	    static void deleteFile() {
	        deleteBackup();
	        new File( filename ).delete();
	        new File( idxname ).delete();
	    }
		
	    private static void backup() {
	        deleteBackup();
	        new File( filename ).renameTo( new File( filenameBak ));
	        new File( idxname ).renameTo( new File( idxnameBak ));
	    }
            
    static public String output = "";
    static boolean deleteFile( String[] args ) 
	            throws ClassNotFoundException, IOException, KeyNotUniqueException {
	        //-dk  {i|a|n} key      - clear data by key
	        if ( args.length != 3 ) {
	            System.err.println( "Invalid number of arguments" );
	            return false;
	        }
	        Vector<Long> poss = null;
	        try ( Index idx = Index.load( idxname )) {
	            IndexBase pidx = indexByArg( args[1], idx );
	            if ( pidx == null ) {
	                return false;
	            }
	            if ( pidx.contains(args[2])== false ) {
	                System.err.println( "Key not found: " + args[2] );
	                return false;				
	            }
	            poss = pidx.get(args[2]);
	        }
	        backup();
	        Collections.sort( poss );
	        try ( Index idx = Index.load( idxname ); 
	              RandomAccessFile fileBak= new RandomAccessFile(filenameBak, "rw");
	              RandomAccessFile file = new RandomAccessFile( filename, "rw")) {
	            boolean[] wasZipped = new boolean[] {false};
	            long pos;
	            while (( pos = fileBak.getFilePointer()) < fileBak.length() ) {
	            	Business_Firm toy = (Business_Firm) 
	                Buffer.readObject( fileBak, pos, wasZipped );
	                if ( Collections.binarySearch(poss, pos) < 0 ) { // if not found in deleted
	                    long ptr = Buffer.writeObject( file, toy, wasZipped[0] );
	                    idx.put( toy, ptr );
	                }
	             }
	         }
	         return true;
	    }
	
    static public void appendFile(Business_Firm apart, Boolean zipped ) 
            throws FileNotFoundException, IOException, ClassNotFoundException, 
                KeyNotUniqueException {
        //Scanner fin = new Scanner( System.in, encoding );
        //apartmnetsOut.println( "Enter apartment data: " );
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            idx.test( apart );
            long pos = Buffer.writeObject( raf, apart, zipped );
            idx.put( apart, pos );
           
        }
    }
	
    private static String printRecord( RandomAccessFile raf, long pos ) 
            throws ClassNotFoundException, IOException {
        String out = "";
        boolean[] wasZipped = new boolean[] {false};
        Business_Firm apart = (Business_Firm) Buffer.readObject( raf, pos, wasZipped );
        if ( wasZipped[0] == true ) {
            //System.out.print( " compressed" );
            out += " compressed";
        }
        //System.out.println( " record at position "+ pos + ": \n" + apart );
        out += " record at position "+ pos + ": \n" + apart;
        return out;
    }
	
    private static void printRecord( RandomAccessFile raf, String key, 
            IndexBase pidx ) throws ClassNotFoundException, IOException {
        Vector<Long> poss = pidx.get( key );
        for ( long pos : poss ) {
            //System.out.print "*** Key: " +  key + " points to" );
            output += "*** Key: " +  key + " points to";
            output += printRecord( raf, pos );
        }		
    }
    
    static void printFile() 
            throws FileNotFoundException, IOException, ClassNotFoundException {
        long pos;
        int rec = 0;
        try ( RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            while (( pos = raf.getFilePointer()) < raf.length() ) {
                //System.out.print( "#" + (++rec ));
                output+="\n\n\t#" + (++rec);
                output += printRecord( raf, pos );
            }
            //System.out.flush();
        }
    }
	
    private static IndexBase indexByArg( String arg, Index idx ) {
        IndexBase pidx = null;
        if ( arg.equals("p")) {
	            pidx = idx.providers;
	        } 
	        else if ( arg.equals("d")) {
	            pidx = idx.datas;
	        } 
	        else if ( arg.equals("a")) {
	            pidx = idx.age_limits;
	        } 
	        else {
	            System.err.println( "Invalid index specified: " + arg );
	        }
	        return pidx;
    }
	
    static boolean printFile( String[] args, boolean reverse ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 2 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx == null ) {
                return false;
            }
            String[] keys = 
	                pidx.getKeys( reverse ? new KeyCompReverse() : new KeyComp() );
	    for ( String  key : keys ) {
                printRecord( raf, key, pidx );
            }
        }
        return true;
    }
	
    static boolean findByKey( String[] args ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 3 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx.contains(args[2])== false ) {
                System.err.println( "Key not found: " + args[2] );
                return false;				
            }
            printRecord( raf, args[2], pidx );
        }
        return true;	
    }
	
    static boolean findByKey( String[] args, Comparator<String>  comp ) 
            throws ClassNotFoundException, IOException {
        if ( args.length != 3 ) {
            System.err.println( "Invalid number of arguments" );
            return false;
        }
        try ( Index idx = Index.load( idxname ); 
              RandomAccessFile raf = new RandomAccessFile( filename, "rw" )) {
            IndexBase pidx = indexByArg( args[1], idx );
            if ( pidx.contains(args[2])== false ) {
                System.err.println( "Key not found: " + args[2] );
                return false;				
            }
            String[] keys = pidx.getKeys( comp );
	            for ( int i = 0; i < keys.length; i++ ) {
	                String key = keys[i];
	                if ( key.equals( args[2] )) {
	                    break;
	                }
	                printRecord( raf, key, pidx );
            }
        }
        return true;
    }
}
